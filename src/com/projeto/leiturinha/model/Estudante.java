package com.projeto.leiturinha.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.projeto.leiturinha.utils.DateUtil;

@Entity
public class Estudante {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private String nome;
	private String email;
	private String senha;
	
	public Estudante() {
		
	}

	public Estudante(Date dataNascimento, String nome, String email, String senha) {

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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

	private String getDataFormatada() {
		return DateUtil.dateToString(dataNascimento);
	}
	@Override
	public String toString() {
		return "Estudante [id=" + id + ", dataNascimento=" + getDataFormatada() + ", nome=" + nome + ", email=" + email
				+ ", senha=" + senha + "]";
	}
	
}