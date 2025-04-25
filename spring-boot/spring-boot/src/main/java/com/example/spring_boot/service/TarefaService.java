package com.example.spring_boot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.model.Tarefa;
import com.example.spring_boot.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public boolean validacao(Tarefa tarefa){
        if((tarefa.getTitulo()).length() >= 3 && tarefa.getStatus() != null ){
            return true;
        }
        return false;
    }

    public Tarefa postSaveTarefa(Tarefa tarefa){
        if(validacao(tarefa)==true){
            return tarefaRepository.save(tarefa);
        }
        return null;
    }

    public Tarefa getTarefaById(String id){
        Tarefa tarefa = tarefaRepository.findByid(id);
        if(tarefa!=null){
            return tarefa;
        }
        return null;
    }

    public List getTarefas(){
      return this.tarefaRepository.findAll();
    }

    public Tarefa putAtualizaTarefa(String id,Tarefa tarefaAtualizada){
        Tarefa tarefa = getTarefaById(id);
        if(tarefa!=null && validacao(tarefaAtualizada)==true){
            tarefa.setDataCriacao(tarefaAtualizada.getDataCriacao());
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setStatus(tarefa.getStatus());
            tarefa.setTitulo(tarefaAtualizada.getTitulo());
            tarefaRepository.save(tarefa);
            return tarefa;
        }
        return null;
    }

    public void delTarefaById(String id){
        Tarefa tarefa = getTarefaById(id);
        if(tarefa!=null){
            this.tarefaRepository.deleteById(id);
        }
    }


}
