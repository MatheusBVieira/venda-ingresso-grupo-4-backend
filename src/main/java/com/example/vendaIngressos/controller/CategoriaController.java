package com.example.vendaIngressos.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendaIngressos.controller.form.CategoriaForm;
import com.example.vendaIngressos.model.Categoria;
import com.example.vendaIngressos.service.CategoriaService;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

  @Autowired
  private CategoriaService categoriaService;

  @GetMapping
  public Page<Categoria> lista(
      @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 25) Pageable paginacao) {
    return categoriaService.lista(paginacao);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid CategoriaForm form) {
    Categoria categoria = categoriaService.insere(form);
    return ResponseEntity.ok(categoria);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<?> remover(@PathVariable Long id) {
    if (categoriaService.deleta(id)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

}
