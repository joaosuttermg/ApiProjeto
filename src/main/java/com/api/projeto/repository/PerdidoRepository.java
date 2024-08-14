package com.api.projeto.repository;

import com.api.projeto.classes.Perdido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerdidoRepository extends JpaRepository<Perdido, Long> {
}
