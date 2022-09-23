package com.projeto.leiturinha.controllers;

import java.sql.SQLException;

import com.projeto.leiturinha.dao.ProfessorDAO;
import com.projeto.leiturinha.model.Professor;

public class ProfessorController {

	
	private ProfessorDAO dao;

	public ProfessorController(ProfessorDAO dao) {
		this.dao = dao;
	}
	
	public void salva(String nome, String email, String instituicao) {
		Professor professor = criaProfessor(nome, email, instituicao);
		dao.salva(professor);
		System.out.println("Professor salvo com sucesso");
	}

	public void altera(Integer id, String nome, String email, String instituicao) {
		Professor professor = criaProfessor(nome, email, instituicao);
		professor.setId(id);
		dao.altera(professor);
		System.out.println("Professor alterado com sucesso");
	}
	

	public void remove(int idParaExcluir) {
		try {
			dao.remove(idParaExcluir);
			System.out.println("Professor excluído com êxito");
			
		} catch(SQLException ex) {
           		System.out.println(ex.getMessage());
		}
	}
	
	public void listaProfessores() {
	   dao.listaProfessores()
	   	.forEach(System.out::println);
	}
	
	private Professor criaProfessor(String nome, String email, String instituicao) {
		return new Professor(nome, email, instituicao);
	}
}
