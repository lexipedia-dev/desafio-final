package br.edu.xp.desafiofinal.model.repository;

import br.edu.xp.desafiofinal.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);

}
