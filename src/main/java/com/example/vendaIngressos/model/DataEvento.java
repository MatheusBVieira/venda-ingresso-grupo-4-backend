package com.example.vendaIngressos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "data_evento")
public class DataEvento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String horarioInicio;
  private String horarioFim;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date dataInicio;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date dataFim;

  public void setId(Long id) {
    this.id = id;
  }

  public String getHorarioInicio() {
    return horarioInicio;
  }

  public void setHorarioInicio(String horarioInicio) {
    this.horarioInicio = horarioInicio;
  }

  public String getHorarioFim() {
    return horarioFim;
  }

  public void setHorarioFim(String horarioFim) {
    this.horarioFim = horarioFim;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public Date getDataFim() {
    return dataFim;
  }

  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }

  public DataEvento(String horarioInicio, String horarioFim, Date dataInicio, Date dataFim) {
    this.horarioInicio = horarioInicio;
    this.horarioFim = horarioFim;
    this.dataInicio = dataInicio;
  }

  public DataEvento() {
  }

}
