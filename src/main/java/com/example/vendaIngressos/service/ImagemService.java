package com.example.vendaIngressos.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.example.vendaIngressos.model.Imagem;
import com.example.vendaIngressos.repository.ImagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagemService {

  @Autowired
  ImagemRepository imagemRepository;

  public Imagem insere(MultipartFile file) throws IOException {
    Imagem img = new Imagem(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
    imagemRepository.save(img);
    return img;
  }

  public Imagem getImagem(String imageName) {
    final Optional<Imagem> retrievedImage = imagemRepository.findByName(imageName);
    return new Imagem(retrievedImage.get().getName(), retrievedImage.get().getType(),
        decompressBytes(retrievedImage.get().getPicByte()));
  }

  // compress the image bytes before storing it in the database
  public static byte[] compressBytes(byte[] data) {
    Deflater deflater = new Deflater();
    deflater.setInput(data);
    deflater.finish();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    while (!deflater.finished()) {
      int count = deflater.deflate(buffer);
      outputStream.write(buffer, 0, count);
    }
    try {
      outputStream.close();
    } catch (IOException e) {
    }
    System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
    return outputStream.toByteArray();
  }

  // uncompress the image bytes before returning it to the angular application
  public static byte[] decompressBytes(byte[] data) {
    Inflater inflater = new Inflater();
    inflater.setInput(data);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    try {
      while (!inflater.finished()) {
        int count = inflater.inflate(buffer);
        outputStream.write(buffer, 0, count);
      }
      outputStream.close();
    } catch (IOException ioe) {
    } catch (DataFormatException e) {
    }
    return outputStream.toByteArray();
  }

}
