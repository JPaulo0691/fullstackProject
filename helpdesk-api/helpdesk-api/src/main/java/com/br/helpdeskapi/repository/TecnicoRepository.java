package com.br.helpdeskapi.repository;

import com.br.helpdeskapi.domain.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
}
