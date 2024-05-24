package com.example.projetoathenas1.repository;

import com.example.projetoathenas1.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
           Optional<Pessoa> findByNomeIgnoreCase(String nome);
}
