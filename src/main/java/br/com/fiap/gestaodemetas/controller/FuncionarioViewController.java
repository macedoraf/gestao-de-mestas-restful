package br.com.fiap.gestaodemetas.controller;

import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.service.EmpresaService;
import br.com.fiap.gestaodemetas.service.FuncionarioService;
import br.com.fiap.gestaodemetas.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.function.Consumer;

@Controller
public class FuncionarioViewController {

    public Funcionario funcionario = new Funcionario();

    @Autowired
    public FuncionarioService funcionarioService;

    @Autowired
    public MetaService metaService;

    @Autowired
    public EmpresaService empresaService;

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
    public String cadastraFuncionarioView(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("empresas", empresaService.getAll());
        return "cadastra-funcionario";
    }

    @GetMapping("/cadastra-funcionario/{id}")
    public String atualizaFuncionarioView(@PathVariable("id") long id, Model model) {
        funcionarioService.getAll().forEach(new Consumer<Funcionario>() {
            @Override
            public void accept(Funcionario funcionario) {
                if (funcionario.getId() == id) {
                    model.addAttribute("funcionario", funcionario);
                }
            }
        });

        model.addAttribute("empresas", empresaService.getAll());
        return "cadastra-funcionario";
    }

    @GetMapping("metas-funcionario/{id}")
    public String metasFuncionario(@PathVariable("id") long id, Model model) {
        model.addAttribute("metas", metaService.getAll());
        model.addAttribute("meta-selecionada", new Meta());
        funcionarioService.getAll().forEach(new Consumer<Funcionario>() {
            @Override
            public void accept(Funcionario funcionario) {
                if (funcionario.getId() == id) {
                    model.addAttribute("funcionario", funcionario);
                }
            }
        });
        return "metas-funcionario";
    }

}
