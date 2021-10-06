package br.com.fiap.gestaodemetas.controller;

import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpresaViewController {

    public Empresa empresa = new Empresa();

    @Autowired
    public EmpresaService empresaService;

    @GetMapping("lista-empresa")
    public String index(@ModelAttribute("empresa") Empresa empresa, Model model) {
        this.empresa = empresa;
        model.addAttribute("empresas", empresaService.getAll());
        return "lista-empresa";
    }

    @PostMapping("/cadastra-empresa")
    public String cadastraEmpresa(@ModelAttribute("empresa") Empresa empresa, BindingResult result, Model model) {
        Empresa resultEmpresa = empresaService.create(empresa);
        return "cadastra-empresa";
    }

}
