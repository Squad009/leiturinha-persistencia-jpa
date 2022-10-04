package com.projeto.leiturinha.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.projeto.leiturinha.controllers.ContoController;
import com.projeto.leiturinha.dao.ContoDAO;
import com.projeto.leiturinha.dao.EstudanteDAO;
import com.projeto.leiturinha.utils.JPAUtil;
import com.projeto.leiturinha.utils.ViewUtil;

public class ContoTeste {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		EntityManager em = JPAUtil.getEntityManager();
		ContoDAO dao = new ContoDAO(em);
		EstudanteDAO estudanteDAO = new EstudanteDAO(em);
		ContoController controller = new ContoController(dao, estudanteDAO);
		
		do {
			
			ViewUtil.introView("CRUD Conto");
			opcao = Integer.parseInt(sc.nextLine());
			
		switch(opcao) {
			
			case 1: 
				em.getTransaction().begin();
				System.out.println("Titulo: ");
				String titulo = sc.nextLine();
				System.out.println("Conteudo:");
				String conteudo = sc.nextLine();
				System.out.println("Categoria:");
				String categoria = sc.nextLine();
				System.out.println("Imagem de capa:");
				String imagemCapa = sc.nextLine();
				System.out.println("Id do estudante:");
				Integer id_estudante = Integer.parseInt(sc.nextLine());
				
				controller.salva(titulo, conteudo, categoria, id_estudante, imagemCapa);;
				break;
				
			case 2:
				em.getTransaction().begin();
				System.out.println("Informe um id válido:");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Titulo: ");
				String novoTitulo = sc.nextLine();
				System.out.println("Conteudo:");
				String novoConteudo = sc.nextLine();
				System.out.println("Imagem :");
				String novaImagem = sc.nextLine();
				controller.altera(id, novoTitulo, novoConteudo, novaImagem);
				break;
				
			case 3:
				em.getTransaction().begin();
				System.out.println("Informe um id válido para excluir um conto");
				int idParaExcluir = Integer.parseInt(sc.nextLine());
				
				controller.remove(idParaExcluir);
				break;
				
			case 4:
				System.out.println("Lista de contos cadastrados");
				controller.listaContos();
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
