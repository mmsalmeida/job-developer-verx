package com.desafioverx.loginverx.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafioverx.loginverx.model.Cliente;
import com.desafioverx.loginverx.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	
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
	


	public void pegaIP2() {
      	//String urlString = "https://www.whatismyip.org";
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

	} 
	   
}
