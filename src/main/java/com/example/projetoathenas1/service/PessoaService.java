package com.example.projetoathenas1.service;

import com.example.projetoathenas1.entity.Pessoa;
import com.example.projetoathenas1.repository.PessoaRepository;
import com.example.projetoathenas1.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private Task task;

    public Pessoa incluir(Pessoa pessoa) {
       return task.incluir(pessoa);
    }

    public Pessoa buscar(Long id) {
        return task.buscarPessoa(id);
    }

    public void excluir(Long id) {
        task.excluir(id);
    }
}
