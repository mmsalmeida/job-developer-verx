package com.desafioverx.loginverx.controller;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafioverx.loginverx.dto.ClienteDTO;
import com.desafioverx.loginverx.model.Cliente;
import com.desafioverx.loginverx.repository.ClienteRepository;
import com.desafioverx.loginverx.service.ClienteService;





@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteReposityory;
	
	@Autowired
	private ClienteService clienteService;
	
	
	
	@GetMapping(value="/cliente/{Id}")
	public String buscaCliente(@PathVariable String Id) {
		return clienteReposityory.findById(Long.valueOf(Id)).get().toString();
	}
	

	@GetMapping(value="/remove/{Id}")
	public String remove(@PathVariable String Id) {		
		long envio =	Long.parseLong(Id);
		clienteReposityory.deleteById(envio);
		
		return "Cliente deletado!"; 
	}
	
	
	
	@PostMapping(value="/save")
	public String salva(@RequestBody ClienteDTO clienteDTO) throws IOException {
		
		System.out.println("cliente:"+clienteDTO.getNome());
		System.out.println("idade:"+clienteDTO.getIdade());
		clienteService.insertCliente(clienteDTO.getNome(), clienteDTO.getIdade());
		clienteService.pegaIP2();
		return "Cliente salvo com sucesso!";
	}
	
	
	@GetMapping(value="/listacliente")
	public List<Cliente> listarCliente() {
		return clienteReposityory.findAll();
	}

	@PostMapping(value="/alterar/{Id}")
	public String alterarCliente(@PathVariable String Id,@RequestBody ClienteDTO clienteDTO) throws SocketException, UnknownHostException {
		long envio =	Long.parseLong(Id);
		clienteDTO.setId(envio);
		if (clienteReposityory.findById(envio).isPresent()) {
			System.out.println("Id:"+clienteDTO.getId());
			System.out.println("cliente:"+clienteDTO.getNome());
			System.out.println("idade:"+clienteDTO.getIdade());
			clienteService.alteraCliente(clienteDTO.getId(),clienteDTO.getNome(), clienteDTO.getIdade());
			return "teste alteração";
		}
		else
		{
			return "não existe o registro a ser alterado";
		}	
	}
	

	
	
}
