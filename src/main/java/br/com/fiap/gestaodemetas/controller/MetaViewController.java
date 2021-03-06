package br.com.fiap.gestaodemetas.controller;

import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.service.EmpresaService;
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
public class MetaViewController {

    public Meta meta = new Meta();

    @Autowired
    public MetaService metaService;

    @Autowired
    public EmpresaService empresaService;

    @GetMapping("lista-meta")
    public String index(@ModelAttribute("meta") Meta meta, Model model) {
        this.meta = meta;
        model.addAttribute("metas", metaService.getAll());
        return "lista-meta";
    }

    @PostMapping("/cadastra-meta")
    public String cadastraMeta(@ModelAttribute("meta") Meta meta, BindingResult result, Model model) {
        if (meta.getId() != 0) {
            metaService.update(meta.getId(), meta);
        } else {
            metaService.create(meta);
        }

        return "redirect:/lista-meta";
    }

    @GetMapping("/deleta-meta/{id}")
    public String deletaMeta(@PathVariable("id") long id) {
        metaService.delete(id);
        return "redirect:/lista-meta";
    }

    @GetMapping("/cadastra-meta")
    public String cadastrametaView(Model model) {
        model.addAttribute("meta", new Meta());
        model.addAttribute("empresas", empresaService.getAll());
        return "cadastra-meta";
    }

    @GetMapping("/cadastra-meta/{id}")
    public String atualizaMetaView(@PathVariable("id") long id, Model model) {
        metaService.getAll().forEach(new Consumer<Meta>() {
            @Override
            public void accept(Meta Meta) {
                if (Meta.getId() == id) {
                    model.addAttribute("meta", Meta);
                }
            }
        });

        model.addAttribute("empresas", empresaService.getAll());
        return "cadastra-Meta";
    }
}
