package br.com.fiap.gestaodemetas.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class BaseController<Entity> {

    protected abstract BaseService<Entity> service();

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Entity> create(@RequestBody Entity entity) {
        return ResponseEntity.ok(service().create(entity));

    }

    @PutMapping(path = "/{idEntity}")
    @CrossOrigin
    public ResponseEntity<Entity> update(@PathVariable(name = "idEntity") long id, @RequestBody Entity entity) {
        return ResponseEntity.ok(service().update(id, entity));

    }

    @DeleteMapping(path = "/{idEntity}")
    @CrossOrigin
    public ResponseEntity<String> delete(@PathVariable(name = "idEntity") long idEntity) {
        service().delete(idEntity);
        return ResponseEntity.ok("Deletado com Sucesso");
    }


    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<Entity>> listAll() {
        return ResponseEntity.ok(service().getAll());
    }

}
