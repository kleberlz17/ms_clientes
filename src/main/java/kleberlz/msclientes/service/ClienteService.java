package kleberlz.msclientes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kleberlz.msclientes.model.Cliente;
import kleberlz.msclientes.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> buscarPorCpf(String cpf) { 
		return clienteRepository.findByCpf(cpf);
		
	}

}
