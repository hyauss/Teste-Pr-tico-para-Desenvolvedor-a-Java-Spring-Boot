package com.example.spring_boot;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.spring_boot.model.Tarefa;
import com.example.spring_boot.model.Tarefa.status;
import com.example.spring_boot.repository.TarefaRepository;
import com.example.spring_boot.service.TarefaService;

class TarefaTests {

	@Mock
	private TarefaRepository tarefaRepository;
	
	@InjectMocks
	private TarefaService tarefaService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void validacaoTest() {
		Tarefa tarefa = new Tarefa("Título", "Descrição", status.PENDENTE, LocalDateTime.now());
		boolean resultado = tarefaService.validacao(tarefa);
		assertEquals(true, resultado);
	}

	//Tam de titulo.
	@Test
	void validacaoTest2() {
		Tarefa tarefa = new Tarefa("Tí", "Descrição", status.PENDENTE, LocalDateTime.now());
		boolean resultado = tarefaService.validacao(tarefa);
		assertEquals(false, resultado);
	}

	//Status fora do que foi estabelecido na enum.
	@Test
	void validacaoTest3() {
		Tarefa tarefa = new Tarefa("Título", "Descrição", null, LocalDateTime.now());
		boolean resultado = tarefaService.validacao(tarefa);
		assertEquals(false, resultado);
	}
	//Tam de titulo e status fora do que foi estabelecido na enum.
	@Test
	void validacaoTest4() {
		Tarefa tarefa = new Tarefa("Tí", "Descrição", null, LocalDateTime.now());
		boolean resultado = tarefaService.validacao(tarefa);
		assertEquals(false, resultado);
	}

	@Test
	void postSaveTarefaTest() {
		Tarefa tarefa = new Tarefa("Título", "Descrição", status.PENDENTE, LocalDateTime.now());
		when(tarefaService.postSaveTarefa(tarefa)).thenReturn(tarefa);
	}

	@Test
	void getTarefaByIdTest() {
		Tarefa tarefa = new Tarefa("Título", "Descrição", status.PENDENTE, LocalDateTime.now());
		when(tarefaService.getTarefaById(tarefa.getId())).thenReturn(tarefa);
	}

	//Busca por id invalido.
	@Test
	void getTarefaByIdTest2() {
		when(tarefaService.getTarefaById("")).thenReturn(null);
	}

	@Test
	void getTarefasTest() {
		Tarefa tarefa = new Tarefa("Título", "Descrição", status.PENDENTE, LocalDateTime.now());
		Tarefa tarefa2 = new Tarefa("Título", "Descrição", status.PENDENTE, LocalDateTime.now());
		Tarefa tarefa3 = new Tarefa("Título", "Descrição", status.PENDENTE, LocalDateTime.now());
		Tarefa tarefa4 = new Tarefa("Título", "Descrição", status.PENDENTE, LocalDateTime.now());
		List <Tarefa> listaDeTarefas = List.of(tarefa,tarefa2,tarefa3,tarefa4);
		when(tarefaService.getTarefas()).thenReturn(listaDeTarefas);
	}

	@Test
	void putAtualizaTarefaTest() {
		Tarefa tarefa = new Tarefa("Título", "Descrição", status.PENDENTE, LocalDateTime.now());
		Tarefa tarefaAtualizada = new Tarefa("TítuloNovo","DescriçãoNova",status.CONCLUIDO,LocalDateTime.now());
		when(tarefaService.putAtualizaTarefa(tarefa.getId(),tarefaAtualizada)).thenReturn(tarefaAtualizada);
	}
	
	//put em id inválido
	@Test
	void putAtualizaTarefaTest2() {
		Tarefa tarefaAtualizada = new Tarefa("TítuloNovo","DescriçãoNova",status.CONCLUIDO,LocalDateTime.now());
		when(tarefaService.putAtualizaTarefa(null,tarefaAtualizada)).thenReturn(null);
	}

	@Test
	void delTarefaByIdTest() {
		Tarefa tarefa = new Tarefa("Título", "Descrição", status.PENDENTE, LocalDateTime.now());
		tarefaService.delTarefaById(tarefa.getId());
		when(tarefaService.getTarefaById(tarefa.getId())).thenReturn(null);
	}
	
	//delete com id invalido
	@Test
	void delTarefaByIdTest2() {
		tarefaService.delTarefaById(null);
	}
}