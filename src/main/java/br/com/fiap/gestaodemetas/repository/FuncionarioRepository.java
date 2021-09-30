package br.com.fiap.gestaodemetas.repository;

import br.com.fiap.gestaodemetas.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { }
