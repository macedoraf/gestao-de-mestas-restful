package br.com.fiap.gestaodemetas.controller;

import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.service.EmpresaService;
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
        if (empresa.getId() != 0) {
            empresaService.update(empresa.getId(), empresa);
        } else {
            empresaService.create(empresa);
        }

        return "redirect:/lista-empresa";
    }

    @GetMapping("/cadastra-empresa")
    public String cadastraEmpresaView(Model model) {
        model.addAttribute(new Empresa());
        return "cadastra-empresa";
    }


    @GetMapping("/deleta-empresa/{id}")
    public String deletaEmpresa(@PathVariable("id") long id) {
        empresaService.delete(id);
        return "redirect:/lista-empresa";
    }

    @GetMapping("/cadastra-empresa/{id}")
    public String atualizaEmpresaView(@PathVariable("id") long id, Model model) {
        empresaService.getAll().forEach(new Consumer<Empresa>() {
            @Override
            public void accept(Empresa empresa) {
                if (empresa.getId() == id) {
                    model.addAttribute("empresa", empresa);
                }
            }
        });

        return "cadastra-empresa";

    }
}
