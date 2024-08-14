package com.api.projeto.controller;

import com.api.projeto.classes.Achado;
import com.api.projeto.classes.Perdido;
import com.api.projeto.service.PerdidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("perdidos")
public class PerdidoController {

    @Autowired
    private PerdidoService perdidoService;

    // Buscar todos os perdidos - getAll
    @GetMapping
    public ResponseEntity<List<Perdido>> getAll() {
        List<Perdido> perdido = perdidoService.getAll();
        return ResponseEntity.ok(perdido);
    }

    // Buscar um perdido por id - getById
    @GetMapping("/{id}")
    public ResponseEntity<Perdido> getById(@PathVariable Long id) {
        Achado perdido = perdidoService.getById(id);

        if (perdido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perdido);
    }

    @PostMapping
    public Perdido criar(@RequestBody Perdido perdido) {
        return perdidoService.criar(perdido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perdido> atualizar(@PathVariable Long id, @RequestBody Perdido perdidoAtualizado) {
        return perdidoService.atualizar(id, perdidoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        perdidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}