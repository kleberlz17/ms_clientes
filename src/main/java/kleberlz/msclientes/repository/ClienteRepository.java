package kleberlz.msclientes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kleberlz.msclientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByCpf(String cpf);

}
