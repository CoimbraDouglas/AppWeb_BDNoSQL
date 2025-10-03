package com.exemplo.api_tarefas_mongodb.service;



import com.exemplo.api_tarefas_mongodb.model.Tarefa;
import com.exemplo.api_tarefas_mongodb.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Optional<Tarefa> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Tarefa atualizarTarefa(String id, Tarefa tarefa) {
        tarefa.setId(id);
        return repository.save(tarefa);
    }

    public void removerTarefa(String id) {
        repository.deleteById(id);
    }
}

