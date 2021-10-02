package br.com.fiap.gestaodemetas.service;

import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.repository.MetaRepository;
import org.springframework.stereotype.Service;

@Service
public class MetaService extends BaseService<Meta> {
    public MetaService(MetaRepository repository) {
        super(repository);
    }

}
