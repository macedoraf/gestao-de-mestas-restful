package br.com.fiap.gestaodemetas.controller;


import br.com.fiap.gestaodemetas.base.BaseController;
import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.service.FuncionarioService;
import br.com.fiap.gestaodemetas.service.MetaService;
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

    @PostMapping("/add-meta")
    @CrossOrigin
    public ResponseEntity create(@RequestBody RequestAssociate requestAssociate) {
        service.associateWithGoal(requestAssociate.idFunc, requestAssociate.idGoal);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/terminate")
    @CrossOrigin
    public ResponseEntity create(@RequestBody RequestTerminateBy requestTerminateBy) {
        service.terminateBy(requestTerminateBy.idFunc, requestTerminateBy.idGoal);
        return ResponseEntity.ok().build();
    }

    public static class RequestTerminateBy {
        private long idGoal;
        private long idFunc;

        public RequestTerminateBy(long idGoal, long idFunc) {
            this.idGoal = idGoal;
            this.idFunc = idFunc;
        }

        public long getIdGoal() {
            return idGoal;
        }

        public void setIdGoal(long idGoal) {
            this.idGoal = idGoal;
        }

        public long getIdFunc() {
            return idFunc;
        }

        public void setIdFunc(long idFunc) {
            this.idFunc = idFunc;
        }
    }

    public static class RequestAssociate {

        private long idGoal;
        private long idFunc;

        public RequestAssociate(long idGoal, long idFunc) {
            this.idGoal = idGoal;
            this.idFunc = idFunc;
        }

        public long getIdGoal() {
            return idGoal;
        }

        public void setIdGoal(long idGoal) {
            this.idGoal = idGoal;
        }

        public long getIdFunc() {
            return idFunc;
        }

        public void setIdFunc(long idFunc) {
            this.idFunc = idFunc;
        }
    }
}
