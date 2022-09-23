package com.projeto.leiturinha.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.projeto.leiturinha.controllers.ProfessorController;
import com.projeto.leiturinha.dao.ProfessorDAO;
import com.projeto.leiturinha.utils.JPAUtil;
import com.projeto.leiturinha.utils.ViewUtil;

public class ProfessorTeste {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;
		
		EntityManager em = JPAUtil.getEntityManager();
		ProfessorDAO dao = new ProfessorDAO(em);
		ProfessorController controller = new ProfessorController(dao);
		
		
		do {
			
			ViewUtil.introView("CRUD Professor");
			opcao = Integer.parseInt(sc.nextLine());
			
		switch(opcao) {
			
			case 1: 
				em.getTransaction().begin();
				System.out.println("Nome do professor: ");
				String nome = sc.nextLine();
				System.out.println("Email:");
				String email = sc.nextLine();
				System.out.println("Instituição de ensino:");
				String instituicao = sc.nextLine();
				
				controller.salva(nome, email, instituicao);
				break;
				
			case 2:
				em.getTransaction().begin();
				System.out.println("Informe um id válido:");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Nome do professor: ");
				String novoNome = sc.nextLine();
				System.out.println("Email:");
				String novoEmail = sc.nextLine();
				System.out.println("Instituição de ensino:");
				String novaInstituicao = sc.nextLine();
				
				controller.altera(id, novoNome, novoEmail, novaInstituicao);
				break;
				
			case 3:
				em.getTransaction().begin();
				System.out.println("Informe um id válido para excluir um professor");
				int idParaExcluir = Integer.parseInt(sc.nextLine());
				
				controller.remove(idParaExcluir);
				break;
				
			case 4:
				System.out.println("Lista de professores cadastrados");
				controller.listaProfessores();
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
