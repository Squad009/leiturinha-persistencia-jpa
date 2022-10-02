package com.projeto.leiturinha.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comentarios {
   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer id_conto;
	
	@Column
	private String autor;
	
	@Column
	private String mensagem;
	
	@Temporal(TemporalType.TIMESTAMP) //definir padr�o data e hora
	private Date data_hora_msg;
	

	public Comentarios(String autor, String mensagem) {
		
		this.autor = autor;
		this.mensagem = mensagem;
		this.data_hora_msg = Calendar.getInstance().getTime();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId_conto() {
		return id_conto;
	}


	public void setId_conto(Integer id_conto) {
		this.id_conto = id_conto;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public Date getData_hora_msg() {
		return data_hora_msg;
	}


	public void setData_hora_msg(Date data_hora_msg) {
		this.data_hora_msg = data_hora_msg;
	}
	
	@Override
	public String toString() {
		return "{ autor = " + this.autor +
				" mensagem = " + this.mensagem +
				" }";
	}
	
	
}	