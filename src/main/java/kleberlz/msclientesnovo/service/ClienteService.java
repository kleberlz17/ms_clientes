package kleberlz.msclientesnovo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kleberlz.msclientesnovo.model.Cliente;
import kleberlz.msclientesnovo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente salvar(Cliente cliente) {
		if(cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
			throw new IllegalArgumentException("O CPF não deve ser nulo ou vazio.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> buscarPorCpf(String cpf) {
		Optional<Cliente> clienteCpf = clienteRepository.findByCpf(cpf);
		return clienteCpf;
		
	}
}
