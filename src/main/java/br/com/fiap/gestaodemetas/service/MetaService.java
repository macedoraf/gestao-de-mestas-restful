package br.com.fiap.gestaodemetas.service;

import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.repository.MetaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetaService extends BaseService<Meta> {
    public MetaService(MetaRepository repository) {
        super(repository);
    }

    public List<Meta> findMetasByFuncionario(long idFuncionario) {
        List<Meta> resultMetas = new ArrayList<>();
        repository.findAll().forEach(meta -> {
            if (meta.getFuncionario().getId() == idFuncionario) {
                resultMetas.add(meta);
            }
        });
        return resultMetas;
    }
}
