package com.br.helpdeskapi.repository;

import com.br.helpdeskapi.domain.entity.Pessoa;
import com.br.helpdeskapi.domain.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
}
