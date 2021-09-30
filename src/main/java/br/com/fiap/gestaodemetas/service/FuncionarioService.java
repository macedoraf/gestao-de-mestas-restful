package br.com.fiap.gestaodemetas.service;

import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.repository.FuncionarioRepository;
import br.com.fiap.gestaodemetas.repository.MetaRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService extends BaseService<Funcionario> {
    public FuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }
}
