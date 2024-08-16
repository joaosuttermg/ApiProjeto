package com.api.projeto.service;

import com.api.projeto.classes.Achado;
import com.api.projeto.dto.AchadoDTO;
import com.api.projeto.dto.AchadoUpdateDTO;
import com.api.projeto.repository.AchadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AchadoService {

    @Autowired
    private AchadoRepository achadoRepository;

    public List<Achado> getAll() {
        return achadoRepository.findAll();
    }

    public Achado getById(Long id) {
        return achadoRepository.findById(id)
                                .orElse(null);
    }
    // public List<Achado> getCategoria(String categoria) {
    //     // Lógica para buscar itens por categoria
    //     Achado achado = achadoService.getByCategoria(categoria);
    //     return achadoRepository.findByCategoria(categoria);
                                
                                
    // }

    public Achado create(Achado achado) {
        // Adicionar tratamentos para garantir que a persistencia 
        // acontece com todos os dados necessários
        Achado achadoSalvo = achadoRepository.save(achado);
        return achadoSalvo;
    }

    public Achado update(Long id, Achado achadoExistente, Achado achadoNovo) {

        if (achadoNovo.getQuemAchou() != null) {
            achadoExistente.setQuemAchou(achadoNovo.getQuemAchou());
        }
        if (achadoNovo.getNomeDoItem() != null) {
            achadoExistente.setNomeDoItem(achadoNovo.getNomeDoItem());
        }
        if (achadoNovo.getCategoria() != null) {
            achadoExistente.setCategoria(achadoNovo.getCategoria());
        }
        if (achadoNovo.getDataDeEncontro() != null) {
            achadoExistente.setDataDeEncontro(achadoNovo.getDataDeEncontro());
        }
        if (achadoNovo.getLocalDeEncontro() != null) {
            achadoExistente.setLocalDeEncontro(achadoNovo.getLocalDeEncontro());
        }
        if (achadoNovo.isAchadoAtivo() != achadoExistente.isAchadoAtivo()) {
            achadoExistente.setAchadoAtivo(achadoNovo.isAchadoAtivo());
        }

        return achadoRepository.save(achadoExistente);
    }

    public Achado delete(Long id) {
        // Delete anterior
        achadoRepository.deleteById(id);

        // Delete lógico
        Achado achado = getById(id);
        achado.setAchadoAtivo(false);

        return achadoRepository.save(achado);
    }

    public List<Achado> getAllAtivos() {
        return achadoRepository.findByAchadoAtivoTrue();
    }



    public AchadoUpdateDTO updateDTO(Achado achadoExistente, AchadoUpdateDTO achadoNovo) {

        // Converter o que é DTO pra Achado

        if (achadoNovo.getQuemAchou() != null) {
            achadoExistente.setQuemAchou(achadoNovo.getQuemAchou());
        }
        if (achadoNovo.getNomeDoItem() != null) {
            achadoExistente.setNomeDoItem(achadoNovo.getNomeDoItem());
        }
        if (achadoNovo.getCategoria() != null) {
            achadoExistente.setCategoria(achadoNovo.getCategoria());
        }
        if (achadoNovo.getDataDeEncontro() != null) {
            achadoExistente.setDataDeEncontro(achadoNovo.getDataDeEncontro());
        }
        if (achadoNovo.getLocalDeEncontro() != null) {
            achadoExistente.setLocalDeEncontro(achadoNovo.getLocalDeEncontro());
        }

        // Atualizar o achadoExistente com os dados do achadoNovo
        Achado achadoSalvo = achadoRepository.save(achadoExistente);

        // Converter o Achado pra DTO 
        AchadoUpdateDTO achadoDTO = new AchadoUpdateDTO();
        achadoDTO.setId(achadoSalvo.getId());
        achadoDTO.setQuemAchou(achadoSalvo.getQuemAchou());
        achadoDTO.setNomeDoItem(achadoSalvo.getNomeDoItem());
        achadoDTO.setCategoria(achadoSalvo.getCategoria());
        achadoDTO.setDataDeEncontro(achadoSalvo.getDataDeEncontro());
        achadoDTO.setLocalDeEncontro(achadoSalvo.getLocalDeEncontro());

        // Retornar
        return achadoDTO;
    }

    public List<AchadoDTO> getAchadosDTO() {

        List<Achado> achados = achadoRepository.findAll();

        List<AchadoDTO> achadosDTO = new ArrayList<>();

        for (Achado achado : achados) {
            AchadoDTO achadoDTO = new AchadoDTO();
            achadoDTO.setId(achado.getId());
            achadoDTO.setNomeDoItem(achado.getNomeDoItem());

            achadosDTO.add(achadoDTO);
        }
        return achadosDTO;
    }
   
}