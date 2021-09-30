package br.com.fiap.gestaodemetas.controller;


import br.com.fiap.gestaodemetas.base.BaseController;
import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.entity.Status;
import br.com.fiap.gestaodemetas.service.FuncionarioService;
import br.com.fiap.gestaodemetas.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("funcionario")
public class FuncionarioController extends BaseController<Funcionario> {

    @Autowired
    private FuncionarioService service;

    @Override
    protected BaseService<Funcionario> service() {
        return service;
    }
}
