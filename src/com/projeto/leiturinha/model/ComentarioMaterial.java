package com.projeto.leiturinha.model;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ComentarioMaterial {
	
	@Id // define como chave prim�ria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // incrementar automaticamente
	private Integer id;
	@Column
	private String autor;
	@Column
	private String mensagem;
	@Column (name = "data_hora_msg")
	@Temporal(TemporalType.TIMESTAMP) //definir padr�o data e hora
	private Date dataHoraMensagem;
	
	@ManyToOne() //o mesmo material pode ter vários comentários
	private Material material;
	
	public ComentarioMaterial(){
		
	}

	public ComentarioMaterial(String autor, String mensagem) {
		
		this.autor = autor;
		this.mensagem = mensagem;
		this.dataHoraMensagem = Calendar.getInstance().getTime();
	}
	
	
	public void setAutor(String autor) {
		this.autor = autor;
		
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
		
	}

	

}
