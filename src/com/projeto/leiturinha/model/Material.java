package com.projeto.leiturinha.model;

import java.sql.Blob;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	
	private String conteudo;
	
	@Temporal(TemporalType.TIMESTAMP) //definir padr�o data e hora
	private Date dataCriacao;
	
	@Column(name = "imagem_conteudo")
	private Blob imagemConteudo;
	
	@ManyToOne() //v�rios materiais para um professor
	private Professor professor;
	
	@Cascade(CascadeType.DELETE)
	@OneToMany(mappedBy = "material")
	private List<Quiz> quizzes;
	
	@Cascade (CascadeType.DELETE)
	@OneToMany(mappedBy = "material")
	private List<ComentarioMaterial> comentarioMateriail;
	
	public Material() {
		
	}
	
	public Material(String titulo, String conteudo, Professor professor) {
		
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.professor = professor;
		this.dataCriacao = Calendar.getInstance().getTime();
	}
	
	public Material(String titulo, String conteudo, 
			Blob imageConteudo, Professor professor) {
		
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.imagemConteudo = imageConteudo;
		this.professor = professor;
		this.dataCriacao = Calendar.getInstance().getTime();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Blob getImagemConteudo() {
		return imagemConteudo;
	}

	public void setImagemConteudo(Blob imagemConteudo) {
		this.imagemConteudo = imagemConteudo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public List<Quiz> getQuizzes() {
		return Collections.unmodifiableList(this.quizzes);
	}
	
	@Override
	public String toString() {
		return "{ t�tulo = " + this.titulo +
				" conte�do = " + this.conteudo +
				" }";
	}
	
}
