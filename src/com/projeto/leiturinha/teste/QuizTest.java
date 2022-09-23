package com.projeto.leiturinha.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.projeto.leiturinha.controllers.QuizController;
import com.projeto.leiturinha.dao.MaterialDAO;
import com.projeto.leiturinha.dao.QuizDAO;
import com.projeto.leiturinha.utils.JPAUtil;
import com.projeto.leiturinha.utils.ViewUtil;

public class QuizTest {

	public static void main(String[] args) {
		
		/*
		 * EntityManager em = JPAUtil.getEntityManager(); em.getTransaction().begin();
		 * MaterialDAO materialDAO = new MaterialDAO(em); QuizDAO quizDAO = new
		 * QuizDAO(em);
		 * 
		 * Material material = materialDAO.buscaPorId(1);
		 * 
		 * Quiz quiz = new Quiz("Se você estiver certo, vai acerta?", "Será essa?",
		 * "Ou essa?", "Ou tavezl esta?", "Quem sabe...", "E essa aqui?", "A",
		 * material);
		 * 
		 * quizDAO.salva(quiz);
		 * 
		 * em.close();
		 */
		
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		EntityManager em = JPAUtil.getEntityManager();
		QuizDAO dao = new QuizDAO(em);
		MaterialDAO materialDAO = new MaterialDAO(em);
		QuizController controller = new QuizController(dao, materialDAO);
		
		do {
			
			ViewUtil.introView("CRUD Quiz");
			opcao = Integer.parseInt(sc.nextLine());
			
		switch(opcao) {
			
			case 1: 
				em.getTransaction().begin();
				System.out.println("Enunciado: ");
				String enunciado = sc.nextLine();
				System.out.println("Opcao A:");
				String opcaoA = sc.nextLine();
				System.out.println("Opcao B:");
				String opcaoB = sc.nextLine();
				System.out.println("Opcao C:");
				String opcaoC = sc.nextLine();
				System.out.println("Opcao D:");
				String opcaoD = sc.nextLine();
				System.out.println("Opcao E:");
				String opcaoE = sc.nextLine();
				System.out.println("Letra com a resposta correta:");
				String opcaoCorreta = sc.nextLine();
				System.out.println("Id do material:");
				Integer id_material = Integer.parseInt(sc.nextLine());
				
				controller.salva(enunciado, opcaoA, opcaoB, opcaoC, opcaoD, opcaoE, opcaoCorreta, id_material);
				break;
				
			case 2:
				em.getTransaction().begin();
				System.out.println("Id do do quiz:");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Enunciado: ");
				String enunciado2 = sc.nextLine();
				System.out.println("Opcao A:");
				String opcaoA2 = sc.nextLine();
				System.out.println("Opcao B:");
				String opcaoB2 = sc.nextLine();
				System.out.println("Opcao C:");
				String opcaoC2 = sc.nextLine();
				System.out.println("Opcao D:");
				String opcaoD2 = sc.nextLine();
				System.out.println("Opcao E:");
				String opcaoE2 = sc.nextLine();
				System.out.println("Letra com a resposta correta:");
				String opcaoCorreta2 = sc.nextLine();
				
				controller.altera(id, enunciado2, opcaoA2, opcaoB2, opcaoC2, opcaoD2, opcaoE2, opcaoCorreta2);
				break;
				
			case 3:
				em.getTransaction().begin();
				System.out.println("Informe um id válido para excluir um quiz");
				int idParaExcluir = Integer.parseInt(sc.nextLine());
				
				controller.remove(idParaExcluir);
				break;
				
			case 4:
				System.out.println("Lista de quizzes cadastrados");
				controller.listaQuizzes();
				break;
			
			case 5:
				em.clear();
				sc.close();
				System.out.println("Programa finalizado com sucesso!");
				break;
				
			default:
				System.out.println("Informe uma opção válida.");
				
			}
			
		}while(opcao != 5);
		 
		
	}
}
