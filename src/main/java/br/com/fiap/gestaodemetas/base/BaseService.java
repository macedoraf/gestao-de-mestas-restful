package br.com.fiap.gestaodemetas.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<S> {

    private final JpaRepository<S, Long> repository;

    public BaseService(JpaRepository<S, Long> repository) {
        this.repository = repository;
    }

    public S create(S entity) {
        return repository.save(entity);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public S update(long id, S entity) {
        repository.deleteById(id);
        return repository.save(entity);
    }

    public List<S> getAll() {
        return repository.findAll();
    }
}
