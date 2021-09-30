package br.com.fiap.gestaodemetas.service;

import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.entity.Status;
import br.com.fiap.gestaodemetas.repository.EmpresaRepository;
import br.com.fiap.gestaodemetas.repository.StatusRepository;
import org.springframework.stereotype.Service;

@Service
public class StatusService extends BaseService<Status> {
    public StatusService(StatusRepository repository) {
        super(repository);
    }
}
