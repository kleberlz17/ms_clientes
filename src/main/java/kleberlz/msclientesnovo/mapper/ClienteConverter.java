package kleberlz.msclientesnovo.mapper;

import org.springframework.stereotype.Component;

import kleberlz.msclientesnovo.dto.ClienteDTO;
import kleberlz.msclientesnovo.model.Cliente;

@Component
public class ClienteConverter {
	
	public Cliente dtoParaEntidade(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setCpf(dto.getCpf());
		cliente.setNome(dto.getNome());
		cliente.setIdade(dto.getIdade());
		
		return cliente;
	}
	
	public ClienteDTO entidadeParaDTO(Cliente entidade) {
		return new ClienteDTO(
				entidade.getCpf(),
				entidade.getNome(),
				entidade.getIdade());
	}

}
