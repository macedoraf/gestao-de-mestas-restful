package br.com.fiap.gestaodemetas.service;

import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.repository.FuncionarioRepository;
import br.com.fiap.gestaodemetas.repository.MetaRepository;
import org.graalvm.compiler.phases.common.inlining.policy.GreedyInliningPolicy;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class FuncionarioService extends BaseService<Funcionario> {
    public FuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }


    public Funcionario login(String name, String password) {
        final Funcionario result = new Funcionario();
        repository.findAll().forEach(funcionario -> {
            if (funcionario.getNome().equals(name) && funcionario.getSenha().equals(password)) {
                result.setCargo(funcionario.getCargo());
                result.setEmail(funcionario.getEmail());
                result.setId(funcionario.getId());
                result.setNome(funcionario.getNome());
                result.setEmpresa(funcionario.getEmpresa());
            }
        });
        return result;
    }
}
