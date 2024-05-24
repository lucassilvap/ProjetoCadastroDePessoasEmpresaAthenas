package com.example.projetoathenas1.task;

import com.example.projetoathenas1.entity.Pessoa;
import com.example.projetoathenas1.repository.PessoaRepository;
import com.example.projetoathenas1.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task {


    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa incluir(Pessoa pessoa){
        Optional <Pessoa> pessoa1 = pessoaRepository.findByNomeIgnoreCase(pessoa.getNome());
        if(pessoa1.isPresent()) {
            return  new Pessoa();
        } else{
            return pessoaRepository.save(pessoa);
        }
    }

    public Pessoa buscarPessoa(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }

    public void excluir(Long id) {
        Pessoa pessoa = buscarPessoa(id);
        pessoaRepository.delete(pessoa);
    }

    public List<Pessoa> buscarTodos(){
        List<Pessoa> pessoas = (List<Pessoa>) pessoaRepository.findAll();
        return pessoas;
    }

    public Pessoa buscarPessoaPorNome(String nome) {
        Optional<Pessoa> pessoa = pessoaRepository.findByNomeIgnoreCase(nome);
        return pessoa.orElseGet(Pessoa::new);
    }
}
