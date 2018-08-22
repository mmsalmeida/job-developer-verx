package com.desafioverx.loginverx.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	
	private String nome;
	private String idade;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "Cliente [Id=" + Id + ", nome=" + nome + ", idade=" + idade + "]";
	}
	
	
	
	
}
