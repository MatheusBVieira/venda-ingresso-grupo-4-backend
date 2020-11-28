package com.example.vendaIngressos.controller.form;

import com.example.vendaIngressos.model.Categoria;

public class CategoriaForm {

  private String descricao;

  public Categoria converter() {
    return new Categoria(descricao);
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
