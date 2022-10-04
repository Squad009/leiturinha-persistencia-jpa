package com.projeto.leiturinha.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Conto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "conteudo")
	private String conteudo;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Estudante estudante;
	
	@Column(name = "imagem_capa")
	private String imagemCapa;
	
	@Column(name = "avaliacao_soma")
	private long avaliacaoSoma;
	
	@Column(name = "total_avaliadores")
	private double totalAvaliadores;
	
	@Cascade(CascadeType.DELETE)
	@OneToMany(mappedBy = "conto")
	private List<Comentarios> comentarios;
	
	
	public Conto() {
		
	}


	public Conto(String titulo, String conteudo, Categoria categoria,
			Estudante estudante, String imagemCapa) {
		
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.categoria = categoria;
		this.estudante = estudante;
		this.imagemCapa = imagemCapa;
	
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


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Estudante getEstudante() {
		return estudante;
	}


	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}


	public String getImagemCapa() {
		return imagemCapa;
	}


	public void setImagemCapa(String imagemCapa) {
		this.imagemCapa = imagemCapa;
	}


	public long getAvaliacaoSoma() {
		return avaliacaoSoma;
	}


	public void setAvaliacaoSoma(long avaliacaoSoma) {
		this.avaliacaoSoma = avaliacaoSoma;
	}


	public double getTotalAvaliadores() {
		return totalAvaliadores;
	}


	public void setTotalAvaliadores(double totalAvaliadores) {
		this.totalAvaliadores = totalAvaliadores;
	}
	
	@Override
	public String toString() {
		return "id = " + this.id + "\n" +
			   "titulo = " + this.titulo + "\n" +
			   "conteudo = " + this.conteudo + "\n";	
	}
}
