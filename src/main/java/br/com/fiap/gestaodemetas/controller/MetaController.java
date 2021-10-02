package br.com.fiap.gestaodemetas.controller;


import br.com.fiap.gestaodemetas.base.BaseController;
import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.entity.Status;
import br.com.fiap.gestaodemetas.service.MetaService;
import br.com.fiap.gestaodemetas.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("meta")
public class MetaController extends BaseController<Meta> {

    @Autowired
    private MetaService service;

    @Override
    protected BaseService<Meta> service() {
        return service;
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity requestMetaByFuncionarioId(@PathVariable("id") long id) {
        List<Meta> result = service.findMetasByFuncionario(id);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
