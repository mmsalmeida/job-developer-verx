package com.desafioverx.loginverx.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafioverx.loginverx.model.Cliente;



@Service
public class ClienteService {
	
	
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public boolean insertCliente(String nome,String idade) {
		
		Cliente cliente = new Cliente();
		
		
		cliente.setNome(nome);
		cliente.setIdade(idade);
		
		
		em.persist(cliente);
			return true;			
	}

	
	@Transactional
	public boolean alteraCliente(Long Id,String nome,String idade) {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(Id);
		cliente.setNome(nome);
		cliente.setIdade(idade);
		
		
		em.merge(cliente);
			return true;			
	}	
	

	@Transactional
	public String removerCliente(Long Id) {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(Id);
		em.remove(Id);
			return "teste remoção";			
	}
	
		
	public String pegaIP3() throws IOException {
		URL url = new URL("http://checkip.amazonaws.com/");	
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		System.out.println("testenew...:"+br.readLine().toString());	
		return br.readLine().toString();
	}


	
	public String pegaIP2() throws IOException {				
      	String urlString ="https://ipvigilante.com/8.8.8.8";     	      	
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
