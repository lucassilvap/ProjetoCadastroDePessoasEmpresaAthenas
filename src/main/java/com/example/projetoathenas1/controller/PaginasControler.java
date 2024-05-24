package com.example.projetoathenas1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasControler {

    @GetMapping("/")
    public String  index(){
        return "index";
    }

    @GetMapping("/cadastrar")
        public String cadastrar(){
            return "cadastrar";
        }
}

