package br.com.fiap.gestaodemetas.controller;


import br.com.fiap.gestaodemetas.base.BaseController;
import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.entity.Usuario;
import br.com.fiap.gestaodemetas.service.EmpresaService;
import br.com.fiap.gestaodemetas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("usuario")
public class UsuarioController extends BaseController<Usuario> {

    @Autowired
    private UsuarioService service;

    @Override
    protected BaseService<Usuario> service() {
        return service;
    }
}
