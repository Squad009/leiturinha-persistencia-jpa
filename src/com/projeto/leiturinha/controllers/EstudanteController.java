package com.projeto.leiturinha.controllers;

import java.sql.SQLException;

import com.projeto.leiturinha.dao.EstudanteDAO;
import com.projeto.leiturinha.model.Estudante;

public class EstudanteController {

	private EstudanteDAO dao;

	public EstudanteController(EstudanteDAO dao) {
		this.dao = dao;
	}
	
	public void salva(String dataNascimento, String nome, String email, String senha) {
		Estudante estudante = criaEstudante(dataNascimento, nome, email, senha);
		dao.salva(estudante);
		System.out.println("Estudante salvo com sucesso");
	}

	public void altera(Integer id, String dataNascimento, String nome, String email, String senha) {
		Estudante estudante = criaEstudante(dataNascimento, nome, email, senha);
		estudante.setId(id);
		dao.altera(estudante);
		System.out.println("Estudante alterado com sucesso");
	}
	
	public void remove(int idParaExcluir) {
		try {
			dao.remove(idParaExcluir);
			System.out.println("Estudante excluido com exito");
			
		} catch(SQLException ex) {
           		System.out.println(ex.getMessage());
		}
	}
	
	public void listaEstudantes() {
	   dao.listaEstudantes()
	   	.forEach(System.out::println);
	}
	
	private Estudante criaEstudante(String dataNascimento, String nome, String email, String senha) {
		return new Estudante(dataNascimento, nome, email, senha);
	}
	
}
