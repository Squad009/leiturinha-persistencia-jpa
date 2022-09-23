package com.projeto.leiturinha.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.projeto.leiturinha.controllers.MaterialController;
import com.projeto.leiturinha.dao.MaterialDAO;
import com.projeto.leiturinha.dao.ProfessorDAO;
import com.projeto.leiturinha.utils.JPAUtil;
import com.projeto.leiturinha.utils.ViewUtil;

public class MaterialTest {
	
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		EntityManager em = JPAUtil.getEntityManager();
		MaterialDAO dao = new MaterialDAO(em);
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		MaterialController controller = new MaterialController(dao, professorDAO);
		
		do {
			
			ViewUtil.introView("CRUD Material");
			opcao = Integer.parseInt(sc.nextLine());
			
		switch(opcao) {
			
			case 1: 
				em.getTransaction().begin();
				System.out.println("Titulo: ");
				String nome = sc.nextLine();
				System.out.println("Conteudo:");
				String email = sc.nextLine();
				System.out.println("Id do professor:");
				Integer id_professor = Integer.parseInt(sc.nextLine());
				
				controller.salva(nome, email, id_professor);
				break;
				
			case 2:
				em.getTransaction().begin();
				System.out.println("Informe um id válido:");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Titulo: ");
				String novoNome = sc.nextLine();
				System.out.println("Conteudo:");
				String novoEmail = sc.nextLine();
				
				controller.altera(id, novoNome, novoEmail);
				break;
				
			case 3:
				em.getTransaction().begin();
				System.out.println("Informe um id válido para excluir um material");
				int idParaExcluir = Integer.parseInt(sc.nextLine());
				
				controller.remove(idParaExcluir);
				break;
				
			case 4:
				System.out.println("Lista de materiais cadastrados");
				controller.listaMateriais();
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
	
