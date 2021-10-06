package br.com.fiap.gestaodemetas.controller;


import br.com.fiap.gestaodemetas.base.BaseController;
import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("meta")
public class MetaController extends BaseController<Meta> {

    @Autowired
    private MetaService service;

    @Override
    protected BaseService<Meta> service() {
        return service;
    }
}
