package com.example.vendaIngressos.controller;

import com.example.vendaIngressos.model.Imagem;
import com.example.vendaIngressos.service.ImagemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagem")
public class ImageController {

  @Autowired
  ImagemService imagemService;

  @GetMapping("/{imageName}")
  public Imagem getImagem(@PathVariable String imageName) {
    return imagemService.getImagem(imageName);
  }

}
