package br.com.fiap.gestaodemetas.controller;

import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.entity.Usuario;
import br.com.fiap.gestaodemetas.service.EmpresaService;
import br.com.fiap.gestaodemetas.service.FuncionarioService;
import br.com.fiap.gestaodemetas.service.MetaService;
import br.com.fiap.gestaodemetas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    public EmpresaService empresaService;

    @Autowired
    public MetaService metaService;

    public Meta meta = new Meta();

    public List<Empresa> empresasDisponiveis = new ArrayList<>();


    @GetMapping
    public String index(@ModelAttribute("user") Usuario user) {
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Usuario user, BindingResult result, Model model) {
        Optional<Usuario> userResult = usuarioService.login(user.getEmail(), user.getPassword());
        boolean isSuccess = userResult.isPresent();
        if (isSuccess) {
            return redirect(model);
        } else {
            return "index";
        }
    }

    @PostMapping("/cadastra-meta")
    public String cadastraMeta(@ModelAttribute("meta") Meta meta, BindingResult result, Model model) {
        Meta resultMeta = metaService.create(meta);
        return redirect(model);
    }

    private String redirect(Model model) {
        model.addAttribute("meta", meta);
        model.addAttribute("empresas", empresasDisponiveis);
        empresasDisponiveis.clear();
        empresasDisponiveis.addAll(empresaService.getAll());
        return "logged";
    }
}
