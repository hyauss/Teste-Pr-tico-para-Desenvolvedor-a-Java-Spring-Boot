package com.example.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, String> {
    Tarefa findByid(String id);
}
