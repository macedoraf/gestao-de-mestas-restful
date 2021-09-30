package br.com.fiap.gestaodemetas.service;

import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.repository.EmpresaRepository;
import br.com.fiap.gestaodemetas.repository.MetaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService extends BaseService<Empresa> {
    public EmpresaService(EmpresaRepository repository) {
        super(repository);
    }
}
