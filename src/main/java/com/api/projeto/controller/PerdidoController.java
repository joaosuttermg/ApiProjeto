package com.api.projeto.controller;

import com.api.projeto.classes.Perdido;
import com.api.projeto.repository.PerdidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perdidos")
public class PerdidoController {

    @Autowired
    private PerdidoRepository perdidoRepository;

    @GetMapping
    public List<Perdido> listarTodos() {
        return perdidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perdido> buscarPorId(@PathVariable Long id) {
        return perdidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Perdido criar(@RequestBody Perdido perdido) {
        return perdidoRepository.save(perdido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perdido> atualizar(@PathVariable Long id, @RequestBody Perdido perdidoAtualizado) {
        return perdidoRepository.findById(id)
                .map(perdido -> {
                    perdido.setNomeDoItem(perdidoAtualizado.getNomeDoItem());
                    perdido.setDataDaPerda(perdidoAtualizado.getDataDaPerda());
                    perdido.setLocalDaPerda(perdidoAtualizado.getLocalDaPerda());
                    perdido.setDescricaoDoItem(perdidoAtualizado.getDescricaoDoItem());
                    return ResponseEntity.ok(perdidoRepository.save(perdido));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return perdidoRepository.findById(id)
                .map(perdido -> {
                    perdidoRepository.delete(perdido);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
