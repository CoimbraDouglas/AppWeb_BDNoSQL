package com.exemplo.api_tarefas_mongodb.repository;



import com.exemplo.api_tarefas_mongodb.model.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefaRepository extends MongoRepository<Tarefa, String> {
}
