package br.com.fiap.gestaodemetas.controller;


import br.com.fiap.gestaodemetas.base.BaseController;
import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("funcionario")
public class FuncionarioController extends BaseController<Funcionario> {

    @Autowired
    private FuncionarioService service;

    @Override
    protected BaseService<Funcionario> service() {
        return service;
    }

    @GetMapping("/login")
    public ResponseEntity requestLogin(@RequestParam("funcional") long funcional,
                                       @RequestParam("password") String password) {
        Funcionario result = service.login(funcional, password);
        if (result != null && result.getNome() != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
