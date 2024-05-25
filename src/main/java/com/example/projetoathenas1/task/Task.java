package com.example.projetoathenas1.task;
import com.example.projetoathenas1.entity.Pessoa;
import com.example.projetoathenas1.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
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

    public List<Pessoa> buscarTodos(){
        List<Pessoa> pessoas = (List<Pessoa>) pessoaRepository.findAll();
        return pessoas;
    }

    public Pessoa buscarPessoaPorNome(String nome) {
        Optional<Pessoa> pessoa = pessoaRepository.findByNomeIgnoreCase(nome);
        return pessoa.orElseGet(Pessoa::new);
    }

    public void excluirPeloNome(String excluir) {
        Pessoa pessoa = buscarPessoaPorNome(excluir);
        pessoaRepository.delete(pessoa);
    }

    public void atualizarPessoa(Pessoa pessoa) {
       Optional<Pessoa> pessoa1 = pessoaRepository.findById(pessoa.getId());
       if(pessoa1.isPresent()){
           pessoa.setId(pessoa1.get().getId());
           if(pessoa1.get().getNome().equals(pessoa.getNome())){
               pessoaRepository.save(pessoa);
           }else if(!Objects.equals(pessoa1.get().getNome(), pessoa.getNome())){
               Optional<Pessoa> pessoa2 = pessoaRepository
                       .findByNomeIgnoreCase(pessoa.getNome());
               if(pessoa2.isEmpty()) pessoaRepository.save(pessoa);
           }
       }
    }
}
