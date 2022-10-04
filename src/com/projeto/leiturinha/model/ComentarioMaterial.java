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
	
	@Id // define como chave prim ria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // incrementar automaticamente
	private Integer id;
	@Column
	private String autor;
	@Column
	private String mensagem;
	@Column (name = "data_hora_msg")
	@Temporal(TemporalType.TIMESTAMP) //definir padr o data e hora
	private Date dataHoraMensagem;
	
	@ManyToOne() //o mesmo material pode ter vários comentários
	private Material material;
	
	public ComentarioMaterial() {
		
	}
	

	public ComentarioMaterial(String autor, String mensagem, Material material) {
		
		this.autor = autor;
		this.mensagem = mensagem;
		this.material = material;
		this.dataHoraMensagem = Calendar.getInstance().getTime();
	}
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHoraMensagem() {
		return dataHoraMensagem;
	}

	public void setDataHoraMensagem(Date dataHoraMensagem) {
		this.dataHoraMensagem = dataHoraMensagem;
	}
	

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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
	

	@Override
	public String toString() {
		return "{autor= " + this.autor + ", mensagem =" + this.mensagem +",data do comentario = "+ this.dataHoraMensagem + "}";
	}

	
	

}