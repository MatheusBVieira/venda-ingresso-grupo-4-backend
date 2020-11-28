package com.example.vendaIngressos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.vendaIngressos.controller.form.CategoriaForm;
import com.example.vendaIngressos.model.Categoria;
import com.example.vendaIngressos.repository.CategoriaRepository;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  public Page<Categoria> lista(Pageable paginacao) {
    return categoriaRepository.findAll(paginacao);
  }

  public Categoria insere(CategoriaForm form) {
    Categoria categoria = form.converter();
    categoriaRepository.save(categoria);
    return categoria;
  }

  public boolean deleta(Long id) {
    Optional<Categoria> optional = categoriaRepository.findById(id);
    if (optional.isPresent()) {
      categoriaRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Optional<Categoria> getOne(Long idCategoria) {
    return categoriaRepository.findById(idCategoria);
  }

}
