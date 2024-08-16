package com.api.projeto.service;

import com.api.projeto.classes.Achado;
import com.api.projeto.dto.AchadoDTO;
import com.api.projeto.dto.AchadoUpdateDTO;
import com.api.projeto.exceptions.ErroInesperado;
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
        try {
            return achadoRepository.findAll();
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao buscar todos os achados: " + e.getMessage());
        }
    }

    public Achado getById(Long id) {
        try {
            return achadoRepository.findById(id)
                                    .orElseThrow(() -> new ErroInesperado("Achado não encontrado com o ID: " + id));
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao buscar achado por ID: " + e.getMessage());
        }
    }

    public Achado create(Achado achado) {
        try {
            return achadoRepository.save(achado);
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao criar um novo achado: " + e.getMessage());
        }
    }

    public Achado update(Long id, Achado achadoExistente, Achado achadoNovo) {
        try {
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
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao atualizar o achado: " + e.getMessage());
        }
    }

    public Achado delete(Long id) {
        try {
            Achado achado = getById(id);
            achadoRepository.deleteById(id);  // Remoção física
            achado.setAchadoAtivo(false);    // Remoção lógica
            return achadoRepository.save(achado);
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao deletar o achado: " + e.getMessage());
        }
    }

    public List<Achado> getAllAtivos() {
        try {
            return achadoRepository.findByAchadoAtivoTrue();
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao buscar todos os achados ativos: " + e.getMessage());
        }
    }

    public AchadoUpdateDTO updateDTO(Achado achadoExistente, AchadoUpdateDTO achadoNovo) {
        try {
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

            Achado achadoSalvo = achadoRepository.save(achadoExistente);

            AchadoUpdateDTO achadoDTO = new AchadoUpdateDTO();
            achadoDTO.setId(achadoSalvo.getId());
            achadoDTO.setQuemAchou(achadoSalvo.getQuemAchou());
            achadoDTO.setNomeDoItem(achadoSalvo.getNomeDoItem());
            achadoDTO.setCategoria(achadoSalvo.getCategoria());
            achadoDTO.setDataDeEncontro(achadoSalvo.getDataDeEncontro());
            achadoDTO.setLocalDeEncontro(achadoSalvo.getLocalDeEncontro());

            return achadoDTO;
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao atualizar o achado DTO: " + e.getMessage());
        }
    }

    public List<AchadoDTO> getAchadosDTO() {
        try {
            List<Achado> achados = achadoRepository.findAll();
            List<AchadoDTO> achadosDTO = new ArrayList<>();

            for (Achado achado : achados) {
                AchadoDTO achadoDTO = new AchadoDTO();
                achadoDTO.setId(achado.getId());
                achadoDTO.setNomeDoItem(achado.getNomeDoItem());

                achadosDTO.add(achadoDTO);
            }
            return achadosDTO;
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao buscar os achados DTO: " + e.getMessage());
        }
    }
}