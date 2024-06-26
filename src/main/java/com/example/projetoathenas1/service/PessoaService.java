package com.example.projetoathenas1.service;

import com.example.projetoathenas1.entity.Pessoa;
import com.example.projetoathenas1.repository.PessoaRepository;
import com.example.projetoathenas1.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private Task task;

    public Pessoa incluir(Pessoa pessoa) {
       return task.incluir(pessoa);
    }

    public List<Pessoa> buscarTodasAsPessoas(){
        return task.buscarTodos();
    }

    public Pessoa buscarPessoaPorNome(String name) {
        return task.buscarPessoaPorNome(name);
    }

    public void excluirPeloNome(String excluir) {
        task.excluirPeloNome(excluir);
    }

    public void atualizarPessoa(Pessoa pessoa) {
       task.atualizarPessoa(pessoa);
    }
}
