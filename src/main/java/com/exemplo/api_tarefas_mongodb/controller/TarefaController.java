package com.exemplo.api_tarefas_mongodb.controller;



import com.exemplo.api_tarefas_mongodb.model.Tarefa;
import com.exemplo.api_tarefas_mongodb.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return service.criarTarefa(tarefa);
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.listarTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable String id, @RequestBody Tarefa tarefa) {
        return service.buscarPorId(id)
                .map(t -> ResponseEntity.ok(service.atualizarTarefa(id, tarefa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(t -> {
                    service.removerTarefa(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

