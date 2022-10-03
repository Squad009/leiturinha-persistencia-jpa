package com.projeto.leiturinha.controllers;

import com.projeto.leiturinha.dao.Estudante_ConteudoDAO;
import com.projeto.leiturinha.model.Estudante_Conteudo;

public class Estudante_ConteudoController {

	private Estudante_ConteudoDAO dao;
	
	public Estudante_ConteudoController(Estudante_ConteudoDAO dao) {
		this.dao = dao;
	}
	
	public void salva(Integer idEstudante, Integer idConteudo) {
		Estudante_Conteudo ec = criaEstudante_Conteudo(idEstudante, idConteudo);
		dao.salva(ec);
		System.out.println("Registro salvo com sucesso");
	}
	

	public void remove(int idParaExcluir) {
		dao.remove(idParaExcluir);
		System.out.println("Registro excluido com exito");
	
	}
	
	public void listaProfessores() {
	   dao.listaEstudante_Conteudo()
	   	.forEach(System.out::println);
	}
	
	private Estudante_Conteudo criaEstudante_Conteudo(Integer idEstudante, Integer idConteudo) {
		return new Estudante_Conteudo(idEstudante, idConteudo);
	}
}
