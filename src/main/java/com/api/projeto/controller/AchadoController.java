package com.api.projeto.controller;

import com.api.projeto.classes.Achado;
import com.api.projeto.repository.AchadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achados")
public class AchadoController {

    @Autowired
    private AchadoRepository achadoRepository;

    @GetMapping
    public List<Achado> listarTodos() {
        return achadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Achado> buscarPorId(@PathVariable Long id) {
        return achadoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Achado criar(@RequestBody Achado achado) {
        return achadoRepository.save(achado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Achado> atualizar(@PathVariable Long id, @RequestBody Achado achadoAtualizado) {
        return achadoRepository.findById(id)
                .map(achado -> {
                    achado.setQuemAchou(achadoAtualizado.getQuemAchou());
                    achado.setNomeDoItem(achadoAtualizado.getNomeDoItem());
                    achado.setCategoria(achadoAtualizado.getCategoria());
                    achado.setDataDeEncontro(achadoAtualizado.getDataDeEncontro());
                    achado.setLocalDeEncontro(achadoAtualizado.getLocalDeEncontro());
                    return ResponseEntity.ok(achadoRepository.save(achado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return achadoRepository.findById(id)
                .map(achado -> {
                    achadoRepository.delete(achado);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
