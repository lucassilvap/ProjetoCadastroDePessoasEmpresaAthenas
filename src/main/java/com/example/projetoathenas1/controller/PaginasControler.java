package com.example.projetoathenas1.controller;
import com.example.projetoathenas1.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaginasControler {

    @Autowired
    PessoaService pessoaService;


    @GetMapping("/")
    public String  index(Model model){
        model.addAttribute("pessoas", pessoaService.buscarTodasAsPessoas());
        return "index";
    }

    @GetMapping("/cadastrar")
        public String cadastrar(){
            return "cadastrar";
    }

    @GetMapping("/pesquisar")
    public String buscar(@RequestParam(name = "nome") String nome, Model model){
        System.out.println(nome);
        model.addAttribute("pessoa", pessoaService.buscarPessoaPorNome(nome));
        return "pesquisar";
    }

}

