package br.com.fiap.gestaodemetas.controller;

import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.service.EmpresaService;
import br.com.fiap.gestaodemetas.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioViewController {

    public Funcionario funcionario = new Funcionario();

    @Autowired
    public FuncionarioService funcionarioService;

    @GetMapping("lista-funcionario")
    public String index(@ModelAttribute("funcionario") Funcionario funcionario, Model model) {
        this.funcionario = funcionario;
        model.addAttribute("funcionarios", funcionarioService.getAll());
        return "lista-funcionario";
    }

    @PostMapping("/cadastra-funcionario")
    public String cadastraEmpresa(@ModelAttribute("funcionario") Funcionario funcionario, BindingResult result, Model model) {
        Funcionario resultEmpresa = funcionarioService.create(funcionario);
        return "redirect:/lista-funcionario";
    }

    @GetMapping("/deleta-funcionario/{id}")
    public String deletaFuncionario(@PathVariable("id") long id) {
        funcionarioService.delete(id);
        return "redirect:/lista-funcionario";
    }

    @GetMapping("/cadastra-funcionario")
    public String cadastraEmpresaView(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "cadastra-funcionario";
    }

}
