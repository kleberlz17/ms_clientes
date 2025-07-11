package kleberlz.msclientesnovo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kleberlz.msclientesnovo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByCpf(String cpf);

}
