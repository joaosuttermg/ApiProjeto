package com.api.projeto.repository;

import com.api.projeto.classes.Achado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchadoRepository extends JpaRepository<Achado, Long> {

    // Método para buscar somente os achados ativos (GetAllAchados)
    List<Achado> findByAchadoAtivoTrue();

}
