package com.projeto.leiturinha.controllers;

import java.sql.SQLException;

import com.projeto.leiturinha.dao.ComentariosDAO;
import com.projeto.leiturinha.model.Comentarios;



public class ComentariosController {
		
	private ComentariosDAO dao;

	public ComentariosController(ComentariosDAO dao) {
		this.dao = dao;
	}
	
	public void salva(String autor, String mensagem) {
		Comentarios comentarios = criaComentarios(autor, mensagem);
		dao.salva(comentarios);
		System.out.println("Comentario salvo com sucesso");
	}

	public void altera(Integer id, String autor, String mensagem) {
		Comentarios comentarios = criaComentarios(autor, mensagem);
		comentarios.setId(id);
		dao.altera(comentarios);
		System.out.println("Comentario alterado com sucesso");
	}
	

	public void remove(int idParaExcluir) {
		try {
			dao.remove(idParaExcluir);
			System.out.println("Comentario exclu�do com �xito");
			
		} catch(SQLException ex) {
           		System.out.println(ex.getMessage());
		}
	}
	
	public void listaComentarios() {
	   dao.listaComentarios()
	   	.forEach(System.out::println);
	}
	
	private Comentarios criaComentarios(String autor, String mensagem) {
		return new Comentarios(autor, mensagem);
	}
}