package com.api.projeto.service;

import com.api.projeto.classes.Perdido;
import com.api.projeto.dto.PerdidoDTO;
import com.api.projeto.dto.PerdidoUpdateDTO;
import com.api.projeto.exceptions.ErroInesperado;
import com.api.projeto.repository.PerdidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PerdidoService {

    @Autowired
    private PerdidoRepository perdidoRepository;

    public List<Perdido> getAll() {
        try {
            return perdidoRepository.findAll();
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao buscar todos os perdidos.");
        }
    }

    public Perdido getById(Long id) {
        try {
            return perdidoRepository.findById(id).orElseThrow(() -> new ErroInesperado("Perdido não encontrado com o ID: " + id));
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao buscar o perdido com o ID: " + id);
        }
    }

    public Perdido create(Perdido perdido) {
        try {
            return perdidoRepository.save(perdido);
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao criar um novo perdido.");
        }
    }

    public Perdido update(Long id, Perdido perdidoExistente, Perdido perdidoNovo) {
        try {
            if (perdidoNovo.getQuemPerdeu() != null) {
                perdidoExistente.setQuemPerdeu(perdidoNovo.getQuemPerdeu());
            }
            if (perdidoNovo.getNomeDoItem() != null) {
                perdidoExistente.setNomeDoItem(perdidoNovo.getNomeDoItem());
            }
            if (perdidoNovo.getDataDaPerda() != null) {
                perdidoExistente.setDataDaPerda(perdidoNovo.getDataDaPerda());
            }
            if (perdidoNovo.getLocalDaPerda() != null) {
                perdidoExistente.setLocalDaPerda(perdidoNovo.getLocalDaPerda());
            }
            if (perdidoNovo.getDescricaoDoItem() != null) {
                perdidoExistente.setDescricaoDoItem(perdidoNovo.getDescricaoDoItem());
            }
            return perdidoRepository.save(perdidoExistente);
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao atualizar o perdido com o ID: " + id);
        }
    }

    public PerdidoUpdateDTO updateDTO(Perdido perdidoExistente, PerdidoUpdateDTO perdidoNovo) {
        try {
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

            Perdido perdidoSalvo = perdidoRepository.save(perdidoExistente);

            PerdidoUpdateDTO perdidoDTO = new PerdidoUpdateDTO();
            perdidoDTO.setId(perdidoSalvo.getId());
            perdidoDTO.setQuemPerdeu(perdidoSalvo.getQuemPerdeu());
            perdidoDTO.setNomeDoItem(perdidoSalvo.getNomeDoItem());
            perdidoDTO.setCategoria(perdidoSalvo.getCategoria());
            perdidoDTO.setDataDaPerda(perdidoSalvo.getDataDaPerda());
            perdidoDTO.setLocalDaPerda(perdidoSalvo.getLocalDaPerda());

            return perdidoDTO;
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao atualizar o DTO do perdido.");
        }
    }

    public Perdido delete(Long id) {
        try {
            Perdido perdido = getById(id);
            perdido.setPerdidoAtivo(false);
            return perdidoRepository.save(perdido);
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao deletar o perdido com o ID: " + id);
        }
    }

    public List<Perdido> getAllAtivos() {
        try {
            return perdidoRepository.findByPerdidoAtivoTrue();
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao buscar todos os perdidos ativos.");
        }
    }

    public List<PerdidoDTO> getPerdidoDTO() {
        try {
            List<Perdido> perdidos = perdidoRepository.findAll();
            List<PerdidoDTO> perdidosDTO = new ArrayList<>();

            for (Perdido perdido : perdidos) {
                PerdidoDTO perdidoDTO = new PerdidoDTO();
                perdidoDTO.setId(perdido.getId());
                perdidoDTO.setNomeDoItem(perdido.getNomeDoItem());
                perdidosDTO.add(perdidoDTO);
            }
            return perdidosDTO;
        } catch (Exception e) {
            throw new ErroInesperado("Erro ao buscar os perdidos como DTO.");
        }
    }
}