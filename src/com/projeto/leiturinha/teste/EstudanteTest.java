package com.projeto.leiturinha.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.projeto.leiturinha.controllers.EstudanteController;
import com.projeto.leiturinha.dao.EstudanteDAO;
import com.projeto.leiturinha.utils.JPAUtil;
import com.projeto.leiturinha.utils.ViewUtil;

public class EstudanteTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;
		
		EntityManager em = JPAUtil.getEntityManager();
		EstudanteDAO dao = new EstudanteDAO(em);
		EstudanteController controller = new EstudanteController(dao);
		
		
		do {
			
			ViewUtil.introView("CRUD Estudante");
			opcao = Integer.parseInt(sc.nextLine());
			
		switch(opcao) {
					
			case 1: 
				em.getTransaction().begin();
				System.out.println("Data de nascimento: ");
				String dataNascimento = sc.nextLine();
				System.out.println("Nome do estudante: ");
				String nome = sc.nextLine();
				System.out.println("Email:");
				String email = sc.nextLine();
				System.out.println("Senha:");
				String senha = sc.nextLine();
				
				controller.salva(dataNascimento, nome, email, senha);
				break;
				
			case 2:
				em.getTransaction().begin();
				System.out.println("Informe um id valido:");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Data nascimento: ");
				String novoDataNascimento = sc.nextLine();
				System.out.println("Nome do estudante: ");
				String novoNome = sc.nextLine();
				System.out.println("Email:");
				String novoEmail = sc.nextLine();
				System.out.println("Senha:");
				String novaSenha = sc.nextLine();
				
				controller.altera(id, novoDataNascimento, novoNome, novoEmail, novaSenha);
				break;
				
			case 3:
				em.getTransaction().begin();
				System.out.println("Informe um id valido para excluir um estudante");
				int idParaExcluir = Integer.parseInt(sc.nextLine());
				
				controller.remove(idParaExcluir);
				break;
				
			case 4:
				System.out.println("Lista de estudantes cadastrados");
				controller.listaEstudantes();
				break;
			
			case 5:
				em.clear();
				sc.close();
				System.out.println("Programa finalizado com sucesso!");
				break;
				
			default:
				System.out.println("Informe uma opcao valida.");
				
			}
			
		}while(opcao != 5);	
	}
}
