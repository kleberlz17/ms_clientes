package kleberlz.msclientes.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kleberlz.msclientes.dto.ClienteDTO;
import kleberlz.msclientes.mapper.ClienteConverter;
import kleberlz.msclientes.model.Cliente;
import kleberlz.msclientes.service.ClienteService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/clientes")
@Slf4j
public class ClienteController {
	
	private final ClienteService clienteService;
	private final ClienteConverter clienteConverter;
	
	public ClienteController(ClienteService clienteService, ClienteConverter clienteConverter) {
		this.clienteService = clienteService;
		this.clienteConverter = clienteConverter;
	}
	
	@GetMapping
	public String status() { //Pra saber que o microserviço está funcionando.
		log.info("Obtendo o status do microservice de clientes");
		return "ok";
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = clienteConverter.dtoParaEntidade(clienteDTO);
		Cliente clienteSalvo = clienteService.salvar(cliente);
		
		URI uri = URI.create("/clientes/" + clienteSalvo.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf) {
		Optional<Cliente> cliente = clienteService.buscarPorCpf(cpf);
		
		if (cliente.isPresent()) {
			log.info("Cliente de CPF {} encontrado no sistema: {}", cpf, cliente);
			return ResponseEntity.ok(cliente.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
