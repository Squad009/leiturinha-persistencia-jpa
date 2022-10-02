package com.projeto.leiturinha.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;
import com.projeto.leiturinha.controllers.ComentariosController;
import com.projeto.leiturinha.dao.ComentariosDAO;
import com.projeto.leiturinha.utils.JPAUtil;
import com.projeto.leiturinha.utils.ViewUtil;

public class ComentariosTest {
  
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;
		
		EntityManager em = JPAUtil.getEntityManager();
		ComentariosDAO dao = new ComentariosDAO(em);
		ComentariosController controller = new ComentariosController(dao);
		
		
		do {
			
			ViewUtil.introView("CRUD Comentarios");
			opcao = Integer.parseInt(sc.nextLine());
			
		switch(opcao) {
			
			case 1: 
				em.getTransaction().begin();
				System.out.println("Nome do autor: ");
				String autor = sc.nextLine();
				System.out.println("Mensagem:");
				String mensagem = sc.nextLine();
				
				
				controller.salva(autor, mensagem);
				break;
				
			case 2:
				em.getTransaction().begin();
				System.out.println("Informe um id v�lido:");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Nome do autor: ");
				String novoAutor = sc.nextLine();
				System.out.println("Mensagem: ");
				String novaMensagem = sc.nextLine();
					
				controller.altera(id, novoAutor, novaMensagem);
				break;
				
			case 3:
				em.getTransaction().begin();
				System.out.println("Informe um id valido para excluir um comentario");
				int idParaExcluir = Integer.parseInt(sc.nextLine());	
				controller.remove(idParaExcluir);
				break;
				
			case 4:
				System.out.println("Listar comentarios");
				controller.listaComentarios();
				break;
			
			case 5:
				em.clear();
				sc.close();
				System.out.println("Programa finalizado com sucesso!");
				break;
				
			default:
				System.out.println("Informe uma op��o v�lida.");
				
			}
			
		}while(opcao != 5);
		
		
	}

}


