package com.desafioverx.loginverx.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

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
//import com.desafioverx.loginverx.




@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteReposityory;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private HttpServletRequest req;
	
	@GetMapping(value="/cliente/{Id}")
	public String login(@PathVariable String Id) {
		return clienteReposityory.findById(Long.valueOf(Id)).get().toString();
	}
	
	@PostMapping(value="/save")
	public String salva(@RequestBody ClienteDTO clienteDTO) throws SocketException, UnknownHostException {
		
		System.out.println("cliente:"+clienteDTO.getNome());
		System.out.println("idade:"+clienteDTO.getIdade());
		clienteService.insertCliente(clienteDTO.getNome(), clienteDTO.getIdade());
		//clienteService.pegaIP2();

      	String urlString ="https://www.whatismyip.org";
     	System.setProperty("http.proxyHost", "ip.do.seu.proxy");
    	System.setProperty("http.proxyPort", "porta_do_proxy");   	
    	try{
       		URL url = new URL(urlString);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				// seta o metodo
				con.setRequestProperty("Request-Method",    "GET");
				// seta a variavel para ler o resultado
				con.setDoInput(true);
				con.setDoOutput(false);
				// abre a conexão pra input
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				// le ate o final
				StringBuffer newData = new StringBuffer(10000);
				String s = "";
				while (null != ((s = br.readLine()))) {
					newData.append(s);
				}
				br.close();
				// imprime o codigo resultante
				System.out.println(new String(newData));
				// imprime o numero do resultado
				System.out.println(
					"Resultado: "
						+ con.getResponseCode()
						+ "/"
						+ con.getResponseMessage());
       	}catch(MalformedURLException me){
				me.printStackTrace();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}		
		
		
		return "teste"; 
	}
	
	

	
	
}
