package com.br.helpdeskapi.repository;

import com.br.helpdeskapi.domain.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado,Integer> {
}
