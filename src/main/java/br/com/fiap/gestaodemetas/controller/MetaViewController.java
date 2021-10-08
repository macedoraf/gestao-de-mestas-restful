package br.com.fiap.gestaodemetas.controller;

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
    public String cadastrameta(@ModelAttribute("meta") Meta meta, BindingResult result, Model model) {
        Meta resultmeta = metaService.create(meta);
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
}
