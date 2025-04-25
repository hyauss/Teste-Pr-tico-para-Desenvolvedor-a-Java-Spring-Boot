package com.example.spring_boot.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Tarefa")
public class Tarefa {
    @Id
    private String id;
    private String titulo;
    private String descricao;

    public enum status {
        PENDENTE, CONCLUIDO
    }

    @Enumerated(EnumType.STRING)
    private status status;
    private LocalDateTime dataCriacao;

    // Getters e Setters

    public String getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // Construtores

    public Tarefa(String titulo, String descricao, status status, LocalDateTime dataCriacao) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }
    

    public Tarefa() {
        this.id = UUID.randomUUID().toString();
        this.titulo = "";
        this.descricao = "";
        this.status = status.PENDENTE;
        this.dataCriacao = null;
    }

}
