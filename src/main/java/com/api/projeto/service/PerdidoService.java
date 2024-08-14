package com.api.projeto.service;

import com.api.projeto.classes.Perdido;
import com.api.projeto.repository.PerdidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerdidoService {

    @Autowired
    private PerdidoRepository perdidoRepository;

    public List<Perdido> listarTodos() {
        return perdidoRepository.findAll();
    }

    public Optional<Perdido> buscarPorId(Long id) {
        return perdidoRepository.findById(id);
    }

    public Perdido criar(Perdido perdido) {
        return perdidoRepository.save(perdido);
    }

    public Optional<Perdido> atualizar(Long id, Perdido perdidoAtualizado) {
        return perdidoRepository.findById(id)
                .map(perdido -> {
                    perdido.setNomeDoItem(perdidoAtualizado.getNomeDoItem());
                    perdido.setDataDaPerda(perdidoAtualizado.getDataDaPerda());
                    perdido.setLocalDaPerda(perdidoAtualizado.getLocalDaPerda());
                    perdido.setDescricaoDoItem(perdidoAtualizado.getDescricaoDoItem());
                    return perdidoRepository.save(perdido);
                });
    }

    public void deletar(Long id) {
        perdidoRepository.deleteById(id);
    }
}