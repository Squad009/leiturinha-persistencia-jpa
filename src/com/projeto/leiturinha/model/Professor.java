package com.projeto.leiturinha.model;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Professor {

	@Id // define como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // incrementar automaticamente
	private Integer id;
	
	private String nome;
	private String email;
	
	@Column(name = "instituicao_ensino") //define nome da coluna
	private String instituicaoEnsino;
	
	@Cascade(CascadeType.DELETE) // Remote todos os materiais relacionados ao professor, usamos para evitar erro de integridade referencial
	@OneToMany(mappedBy = "professor") //identificar o relacionamento bidirecional das classes
	private List<Material> materiais;
	
	public Professor() {
		
	}
	
	public Professor(String nome, String email, String instituicaoEnsino) {
		this.nome = nome;
		this.email = email;
		this.instituicaoEnsino = instituicaoEnsino;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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


	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}


	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public List<Material> getMateriais() {
		return Collections.unmodifiableList(this.materiais);
	}

	@Override
	public String toString() {
		return "{ id:" + this.id +
				  " nome: " + this.nome +
				  " email: " + this.email +
				  " instituicao: " + this.instituicaoEnsino +
				" }";
	}

}
