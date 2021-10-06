package br.com.fiap.gestaodemetas.service;

import br.com.fiap.gestaodemetas.base.BaseService;
import br.com.fiap.gestaodemetas.entity.Empresa;
import br.com.fiap.gestaodemetas.entity.Usuario;
import br.com.fiap.gestaodemetas.repository.EmpresaRepository;
import br.com.fiap.gestaodemetas.repository.UsuarioRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class UsuarioService extends BaseService<Usuario> {
    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

    public Optional<Usuario> login(String email, String password) {
        try {
            final Usuario resultUsuario = new Usuario();
            repository.findAll().forEach(new Consumer<Usuario>() {
                @Override
                public void accept(Usuario usuario) {
                    resultUsuario.setEmail(usuario.getEmail());
                    resultUsuario.setEmpresa(usuario.getEmpresa());
                    resultUsuario.setPassword(usuario.getPassword());
                    resultUsuario.setId(usuario.getId());
                    resultUsuario.setNome(usuario.getNome());
                    usuario.setSobrenome(usuario.getSobrenome());
                }
            });
            return Optional.of(resultUsuario);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
