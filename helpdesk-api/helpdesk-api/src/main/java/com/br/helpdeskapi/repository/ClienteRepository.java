package com.br.helpdeskapi.repository;

import com.br.helpdeskapi.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
