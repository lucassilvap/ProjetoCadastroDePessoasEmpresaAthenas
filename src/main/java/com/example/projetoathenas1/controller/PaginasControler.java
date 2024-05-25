package com.example.projetoathenas1.controller;
import com.example.projetoathenas1.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("pessoa", pessoaService.buscarPessoaPorNome(nome));
        return "pesquisar";
    }

    @DeleteMapping("/excluir/{excluir}")
    public String excluirPessoa(@PathVariable(name = "excluir") String excluir){
        pessoaService.excluirPeloNome(excluir);
        return "index";
    }

    @GetMapping("/atualizar/{editar}")
        public String atualizarPessoa(@PathVariable(name = "editar") String editar, Model model){
        model.addAttribute("pessoa", pessoaService.buscarPessoaPorNome(editar));
        return "formularioEdicao";
    }
}

