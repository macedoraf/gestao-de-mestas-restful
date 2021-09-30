package br.com.fiap.gestaodemetas.controller;


import br.com.fiap.gestaodemetas.base.BaseController;
import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.entity.Status;
import br.com.fiap.gestaodemetas.service.EmpresaService;
import br.com.fiap.gestaodemetas.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("empresa")
public class EmpresaController extends BaseController<Empresa> {

    @Autowired
    private EmpresaService service;

    @Override
    protected BaseService<Empresa> service() {
        return service;
    }
}
