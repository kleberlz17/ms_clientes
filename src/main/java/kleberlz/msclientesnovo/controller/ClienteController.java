package kleberlz.msclientesnovo.controller;

import java.net.URI;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import kleberlz.msclientesnovo.dto.ClienteDTO;
import kleberlz.msclientesnovo.mapper.ClienteConverter;
import kleberlz.msclientesnovo.model.Cliente;
import kleberlz.msclientesnovo.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;
	private final ClienteConverter clienteConverter;
	
	public ClienteController(ClienteService clienteService, ClienteConverter clienteConverter) {
		this.clienteService = clienteService;
		this.clienteConverter = clienteConverter;
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar (@RequestBody @Valid ClienteDTO clienteDTO) {
		Cliente cliente = clienteConverter.dtoParaEntidade(clienteDTO);
		Cliente clienteSalvo = clienteService.salvar(cliente);
		
		URI uri = URI.create("/clientes/" + clienteSalvo.getId());
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Cliente> buscarPorCpf (@PathVariable String cpf) {
		Optional<Cliente> clienteCpf = clienteService.buscarPorCpf(cpf);
		
		if(clienteCpf.isPresent()) {
			return ResponseEntity.ok(clienteCpf.get());
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
			
	

}
