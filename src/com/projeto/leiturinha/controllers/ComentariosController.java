package com.projeto.leiturinha.controllers;

import java.sql.SQLException;

import com.projeto.leiturinha.dao.ComentariosDAO;
import com.projeto.leiturinha.dao.ContoDAO;
import com.projeto.leiturinha.model.Comentarios;
import com.projeto.leiturinha.model.Conto;



public class ComentariosController {
		
	private ComentariosDAO dao;
	private ContoDAO contoDAO;

	public ComentariosController(ComentariosDAO dao, ContoDAO contoDAO) {
		this.dao = dao;
		this.contoDAO = contoDAO;
	}
	
	public void salva(String autor, String mensagem, Integer id_conto) {
		System.out.println("Verifica " + contoDAO.buscaPorId(id_conto));
		Comentarios comentarios = criaComentarios(autor, mensagem, contoDAO.buscaPorId(id_conto));
		dao.salva(comentarios);
		System.out.println("Comentario salvo com sucesso");
	}

	public void altera(Integer id, String autor, String mensagem ) {
		Comentarios comentarios;
		try {
			comentarios = dao.buscaPorId(id);
			comentarios.setAutor(autor);
			comentarios.setMensagem(mensagem);
			dao.altera(comentarios);
			System.out.println("Comentario alterado com sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	private Comentarios criaComentarios(String autor, String mensagem, Conto conto) {
		return new Comentarios(autor, mensagem, conto);
	}
}
