package com.api.projeto.repository;

import com.api.projeto.classes.Achado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchadoRepository extends JpaRepository<Achado, Long> {


}
