package com.projeto.leiturinha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudante {

	@Id // define como chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // incrementar automaticamente
	private Integer id;

	private String dataNascimento;
	private String nome;
	private String email;
	private String senha;
	
	public Estudante() {
		
	}

	public Estudante(String dataNascimento, String nome, String email, String senha) {
		super();
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Estudante [id=" + id + ", dataNascimento=" + dataNascimento + ", nome=" + nome + ", email=" + email
				+ ", senha=" + senha + "]";
	}
	
}