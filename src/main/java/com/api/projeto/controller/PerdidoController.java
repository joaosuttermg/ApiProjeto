package com.api.projeto.controller;

import com.api.projeto.classes.Perdido;
import com.api.projeto.dto.AchadoDTO;
import com.api.projeto.dto.PerdidoDTO;
import com.api.projeto.dto.PerdidoUpdateDTO;
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

    // Buscar todos os perdidos ativos
    @GetMapping("/ativos")
    public ResponseEntity<List<Perdido>> getAllAtivos() {
        List<Perdido> perdido = perdidoService.getAllAtivos();
        return ResponseEntity.ok(perdido);
    }

    // Buscar um perdido por id - getById
    @GetMapping("/{id}")
    public ResponseEntity<Perdido> getById(@PathVariable Long id) {
        Perdido perdido = perdidoService.getById(id);

        if (perdido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perdido);
    }

    @GetMapping("/nomeDoItem")
    public ResponseEntity<List<PerdidoDTO>> getPerdidosDTO() {
        return ResponseEntity.ok(perdidoService.getPerdidoDTO());
    }
   

    // Criar um perdido - create
    @PostMapping
    public ResponseEntity<Perdido> create(@RequestBody Perdido perdido) {
        Perdido perdidoSalvo = perdidoService.create(perdido);
        
        return ResponseEntity.ok(perdidoSalvo);
    }

    // Atualizar um perdido - update
    // Combinação do getById e create
    @PutMapping("/{id}")
    public ResponseEntity<Perdido> update(@PathVariable Long id, @RequestBody Perdido perdidoNovo) {
        Perdido perdidoExistente = perdidoService.getById(id);

        if (perdidoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        Perdido perdidoSalvo = perdidoService.update(id, perdidoExistente, perdidoNovo);

        return ResponseEntity.ok(perdidoSalvo);
    }


    @PutMapping("/dto/{id}")
    public ResponseEntity<PerdidoUpdateDTO> updateDTO (@PathVariable Long id, @RequestBody PerdidoUpdateDTO perdidoNovo) {
        Perdido perdidoExistente = perdidoService.getById(id);

        if (perdidoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        PerdidoUpdateDTO perdidoDTO = perdidoService.updateDTO(perdidoExistente, perdidoNovo);

        return ResponseEntity.ok(perdidoDTO);

    }

    // Deletar um perdido - delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Perdido> delete(@PathVariable Long id) {
        Perdido perdido = perdidoService.getById(id);

        if (perdido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perdidoService.delete(id));
    }
}