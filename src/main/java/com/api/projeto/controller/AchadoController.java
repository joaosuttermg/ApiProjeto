package com.api.projeto.controller;

import com.api.projeto.classes.Achado;
import com.api.projeto.dto.AchadoDTO;
import com.api.projeto.dto.AchadoUpdateDTO;
import com.api.projeto.service.AchadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("achados")
public class AchadoController {

    @Autowired
    private AchadoService achadoService;

    // Buscar todos os achados - getAll
    @GetMapping
    public ResponseEntity<List<Achado>> getAll() {
        List<Achado> achado = achadoService.getAll();
        return ResponseEntity.ok(achado);
    }
    // @GetMapping("/{categoria}")
    // public ResponseEntity<Achado> getByCategoria(@PathVariable String categoria) {
    //     Achado achado = achadoService.getByCategoria(categoria);
        
    //     if (achado == null) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(achado);
    // }

    // @GetMapping("/{categoria}")
    // public ResponseEntity<Achado> getByCategoria(@PathVariable String categoria) {
    //     Achado achado = achadoService.getByCategoria(categoria);
        
    //     if (achado == null) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(categoria);
    // }

    // Buscar um achado por id - getById
    @GetMapping("/{id}")
    public ResponseEntity<Achado> getById(@PathVariable Long id) {
        Achado achado = achadoService.getById(id);

        if (achado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(achado);
    }

    @GetMapping("/nomeDoItem")
    public ResponseEntity<List<AchadoDTO>> getAchadosDTO() {
        return ResponseEntity.ok(achadoService.getAchadosDTO());
    }
   

    // Criar um achado - create
    @PostMapping
    public ResponseEntity<Achado> create(@RequestBody Achado achado) {
        Achado achadoSalvo = achadoService.create(achado);
        
        return ResponseEntity.ok(achadoSalvo);

    }

    // Atualizar um achado - update
    // Combinação do getById e create
    @PutMapping("/{id}")
    public ResponseEntity<Achado> update(@PathVariable Long id, @RequestBody Achado achadoNovo) {
        Achado achadoExistente = achadoService.getById(id);

        if (achadoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        Achado achadoSalvo = achadoService.update(id, achadoExistente, achadoNovo);

        return ResponseEntity.ok(achadoSalvo);
    }


    @PutMapping("/dto/{id}")
    public ResponseEntity<AchadoUpdateDTO> updateDTO (@PathVariable Long id, @RequestBody AchadoUpdateDTO achadoNovo) {
        Achado achadoExistente = achadoService.getById(id);

        if (achadoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        AchadoUpdateDTO achadoDTO = achadoService.updateDTO(achadoExistente, achadoNovo);

        return ResponseEntity.ok(achadoDTO);

    }

    // Deletar um achado - delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Achado> delete(@PathVariable Long id) {
        Achado achado = achadoService.getById(id);

        if (achado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(achadoService.delete(id));
    }
}