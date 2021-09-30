package br.com.fiap.gestaodemetas.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class BaseController<Entity> {

    public final BaseService<Entity> service;

    protected BaseController(BaseService<Entity> service) {
        this.service = service;
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Entity> create(@RequestBody Entity entity) {
        return ResponseEntity.ok(service.create(entity));

    }

    @RequestMapping(path = "/{idEntity}", method = RequestMethod.DELETE)
    @CrossOrigin
    public ResponseEntity<String> delete(@PathVariable(name = "idEntity") long idEntity) {
        service.delete(idEntity);
        return ResponseEntity.ok("Deletado com Sucesso");
    }


    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<Entity>> listAll() {
        return ResponseEntity.ok(service.getAll());
    }

}
