package com.example.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.model.Tarefa;
import com.example.spring_boot.service.TarefaService;


@RestController
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/tarefas")
    public Tarefa postSaveTarefa(@RequestBody Tarefa tarefa) {
        return this.tarefaService.postSaveTarefa(tarefa);
    }
    
    @GetMapping("/tarefas/{id}")
    public Tarefa getTarefaById(@PathVariable String id) {
        return this.tarefaService.getTarefaById(id);
    }

    @GetMapping("/tarefas")
    public List getTarefas() {
        return this.tarefaService.getTarefas();
    }

    @PutMapping("/tarefas/{id}")
    public Tarefa putAtualizaTarefa(@PathVariable String id, @RequestBody Tarefa tarefaAtualizada) {
        return this.tarefaService.putAtualizaTarefa(id, tarefaAtualizada);
    }

    @DeleteMapping("/tarefas/{id}")
    public void delTarefaById(@PathVariable String id) {
        this.tarefaService.delTarefaById(id);
    }
}