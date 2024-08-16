package com.api.projeto.service;

import com.api.projeto.classes.Perdido;

import com.api.projeto.dto.PerdidoDTO;
import com.api.projeto.dto.PerdidoUpdateDTO;
import com.api.projeto.repository.PerdidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.ArrayList;


@Service
public class PerdidoService {

    @Autowired
    private PerdidoRepository perdidoRepository;

    public List<Perdido> getAll() {
        return perdidoRepository.findAll();
    }

    public Perdido getById(Long id) {
        return perdidoRepository.findById(id).orElse(null);
    }

    public Perdido create(Perdido perdido) {
        return perdidoRepository.save(perdido);
    }
    public List<PerdidoDTO> getPerdidoDTO() {

        List<Perdido> perdidos = perdidoRepository.findAll();

        List<PerdidoDTO> perdidosDTO = new ArrayList<>();

        for (Perdido perdido : perdidos) {
            PerdidoDTO perdidoDTO = new PerdidoDTO();
            perdidoDTO.setId(perdido.getId());
            perdidoDTO.setNomeDoItem(perdido.getNomeDoItem());

            perdidosDTO.add(perdidoDTO);
        }
        return perdidosDTO;
    }

    public Perdido update(Long id, Perdido perdidoExistente, Perdido perdidoNovo) {

        if (perdidoNovo.getQuemPerdeu() != null) {
            perdidoExistente.setQuemPerdeu(perdidoNovo.getQuemPerdeu());
        }
        if (perdidoNovo.getNomeDoItem() != null){
            perdidoExistente.setNomeDoItem(perdidoNovo.getNomeDoItem());
        }
        if (perdidoNovo.getDataDaPerda() != null){
            perdidoExistente.setDataDaPerda(perdidoNovo.getDataDaPerda());
        }
        if (perdidoNovo.getLocalDaPerda()!= null){
            perdidoExistente.setLocalDaPerda(perdidoNovo.getLocalDaPerda());
        }
        if (perdidoNovo.getDescricaoDoItem()!= null){
            perdidoExistente.setDescricaoDoItem(perdidoNovo.getDescricaoDoItem());
        }
        return perdidoRepository.save(perdidoExistente);
    }
    public PerdidoUpdateDTO updateDTO(Perdido perdidoExistente, PerdidoUpdateDTO perdidoNovo) {

        // Converter o que é DTO pra Perdido

        if (perdidoNovo.getQuemPerdeu() != null) {
            perdidoExistente.setQuemPerdeu(perdidoNovo.getQuemPerdeu());
        }
        if (perdidoNovo.getNomeDoItem() != null) {
            perdidoExistente.setNomeDoItem(perdidoNovo.getNomeDoItem());
        }
        if (perdidoNovo.getCategoria() != null) {
            perdidoExistente.setCategoria(perdidoNovo.getCategoria());
        }
        if (perdidoNovo.getDataDaPerda() != null) {
            perdidoExistente.setDataDaPerda(perdidoNovo.getDataDaPerda());
        }
        if (perdidoNovo.getLocalDaPerda() != null) {
            perdidoExistente.setLocalDaPerda(perdidoNovo.getLocalDaPerda());
        }

        // Atualizar o achadoExistente com os dados do achadoNovo
        Perdido perdidoSalvo = perdidoRepository.save(perdidoExistente);

        // Converter o Achado pra DTO 
        PerdidoUpdateDTO perdidoDTO = new PerdidoUpdateDTO();
        perdidoDTO.setId(perdidoSalvo.getId());
        perdidoDTO.setQuemPerdeu(perdidoSalvo.getQuemPerdeu());
        perdidoDTO.setNomeDoItem(perdidoSalvo.getNomeDoItem());
        perdidoDTO.setCategoria(perdidoSalvo.getCategoria());
        perdidoDTO.setDataDaPerda(perdidoSalvo.getDataDaPerda());
        perdidoDTO.setLocalDaPerda(perdidoSalvo.getLocalDaPerda());

        // Retornar
        return perdidoDTO;
    }


    public Perdido delete(Long id) {
        // Delete anterior
        perdidoRepository.deleteById(id);

        // Delete lógico
        Perdido perdido = getById(id);
        perdido.setPerdidoAtivo(false);

        return perdidoRepository.save(perdido);
    }
       public List<Perdido> getAllAtivos() {
        return perdidoRepository.findByPerdidoAtivoTrue();
    }
   
}