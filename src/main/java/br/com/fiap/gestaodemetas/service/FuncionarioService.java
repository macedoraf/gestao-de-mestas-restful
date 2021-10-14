package br.com.fiap.gestaodemetas.service;

import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Funcionario;
import br.com.fiap.gestaodemetas.entity.Meta;
import br.com.fiap.gestaodemetas.repository.FuncionarioRepository;
import br.com.fiap.gestaodemetas.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class FuncionarioService extends BaseService<Funcionario> {
    public FuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }

    @Autowired
    public MetaRepository metaRepository;

    public Funcionario login(long funcional, String password) {
        final Funcionario result = new Funcionario();
        repository.findAll().forEach(funcionario -> {
            if (funcionario.getFuncional() == funcional && funcionario.getSenha().equals(password)) {
                result.setCargo(funcionario.getCargo());
                result.setEmail(funcionario.getEmail());
                result.setId(funcionario.getId());
                result.setFuncional(funcionario.getFuncional());
                result.setNome(funcionario.getNome());
                result.setEmpresa(funcionario.getEmpresa());
                result.setMetas(funcionario.getMetas());
            }
        });
        return result;
    }

    public void associateWithGoal(long idFunc, long idMeta) {
        Funcionario funcionario = repository.findById(idFunc).get();
        Optional<Meta> optional = metaRepository.findById(idMeta);
        if (optional.isPresent()) {
            Meta meta = optional.get();

            if (funcionario.getMetas() != null) {
                funcionario.getMetas().add(meta);
            } else {
                funcionario.setMetas(Arrays.asList(meta));
            }
            update(idFunc, funcionario);
        }
    }

    public void terminateBy(long idFunc, long idGoal) {
        Funcionario funcionario = repository.findById(idFunc).get();
        funcionario.getMetas().forEach(new Consumer<Meta>() {
            @Override
            public void accept(Meta meta) {
                if (meta.getId() == idGoal) {
                    meta.setStatus("Feito por " + funcionario.getNome());
                }
            }
        });

        update(idFunc, funcionario);
    }
}
