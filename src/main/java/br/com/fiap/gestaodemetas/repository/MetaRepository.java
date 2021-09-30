package br.com.fiap.gestaodemetas.repository;

import br.com.fiap.gestaodemetas.entity.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {
}
