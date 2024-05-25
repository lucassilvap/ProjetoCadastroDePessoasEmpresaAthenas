package com.example.projetoathenas1.controller;
import com.example.projetoathenas1.entity.Pessoa;
import com.example.projetoathenas1.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<?> salvarPessoa(@RequestBody String string){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            Pessoa pessoa = objectMapper.readValue(string, Pessoa.class);
           pessoaService.incluir(pessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return ResponseEntity.ok(("Salvo com sucesso!"));
    }

    @PutMapping
    public ResponseEntity<?> atualizarPessoa(@RequestBody String string){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            Pessoa pessoa = objectMapper.readValue(string, Pessoa.class);
            pessoaService.atualizarPessoa(pessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(("Atualizado com sucesso!"));
    }

    @GetMapping("/calcularpeso/{nome}")
    public Float calcularPeso(@PathVariable(name = "nome") String nome){
         Pessoa pessoa = pessoaService.buscarPessoaPorNome(nome);
         return pessoa.calcularPesoIdeal();
    }
}
