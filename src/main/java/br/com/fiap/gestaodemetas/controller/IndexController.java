package br.com.fiap.gestaodemetas.controller;

import br.com.fiap.gestaodemetas.base.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index() {
        return "Olá, aplicação esta funcionando corretamente";
    }
}
