package com.projeto.leiturinha.controllers;

import com.projeto.leiturinha.dao.MaterialDAO;
import com.projeto.leiturinha.dao.QuizDAO;
import com.projeto.leiturinha.model.Material;
import com.projeto.leiturinha.model.Quiz;

public class QuizController {

	private MaterialDAO materialDAO;
	private QuizDAO dao;
	
	public QuizController(QuizDAO dao, MaterialDAO materialDAO) {
		this.dao = dao;
		this.materialDAO = materialDAO;
	}
	
	public void salva(String enunciado, String opcaoA, String opcaoB, String opcaoC,
			String opcaoD, String opcaoE, String opcaoCerta, Integer id_material) {
		
		Material material = materialDAO.buscaPorId(id_material);
		Quiz quiz = criaQuiz(enunciado, opcaoA, opcaoB, opcaoC, opcaoD, opcaoE, opcaoCerta, material);
		dao.salva(quiz);
		System.out.println("Quiz salvo com sucesso");
	}

	public void altera(Integer id, String enunciado, String opcaoA, String opcaoB,
			String opcaoC, String opcaoD, String opcaoE, String opcaoCerta) {
		
		Quiz quiz = dao.buscarPorId(id);
		quiz.setEnunciado(enunciado);
		quiz.setOpcaoA(opcaoA);
		quiz.setOpcaoB(opcaoB);
		quiz.setOpcaoC(opcaoC);
		quiz.setOpcaoD(opcaoD);
		quiz.setOpcaoE(opcaoE);
		quiz.setOpcaoCorreta(opcaoCerta);
		
		dao.altera(quiz);
		System.out.println("Quiz alterado com sucesso");
	}
	

	public void remove(Integer idParaExcluir) {
		dao.remove(idParaExcluir);
		System.out.println("Quiz exclu�do com �xito");
	}
	
	public void listaQuizzes() {
	   dao.listaQuizzes()
	   	.forEach(System.out::println);
	}
	
	private Quiz criaQuiz(String enunciado, String opcaoA, String opcaoB, String opcaoC, 
							  String opcaoD, String opcaoE, String opcaoCerta, Material material) {
		
		return new Quiz(enunciado, opcaoA, opcaoB, opcaoC, opcaoD, opcaoE, opcaoCerta, material);
	}
}
