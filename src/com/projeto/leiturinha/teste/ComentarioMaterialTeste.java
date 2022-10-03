package com.projeto.leiturinha.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.projeto.leiturinha.controllers.ComentarioMaterialController;
import com.projeto.leiturinha.dao.ComentarioMaterialDAO;
import com.projeto.leiturinha.dao.MaterialDAO;
import com.projeto.leiturinha.utils.JPAUtil;
import com.projeto.leiturinha.utils.ViewUtil;

public class ComentarioMaterialTeste {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		EntityManager em = JPAUtil.getEntityManager();
		ComentarioMaterialDAO dao = new ComentarioMaterialDAO(em);
		MaterialDAO materialDAO = new MaterialDAO(em);
		ComentarioMaterialController controller = new ComentarioMaterialController(dao, materialDAO);
		
		do {
			
			ViewUtil.introView("CRUD Comentário material");
			opcao = Integer.parseInt(sc.nextLine());
			
		switch(opcao) {
			
		case 1:
			em.getTransaction().begin();
			System.out.println("Seu nome:");
			String autor = sc.nextLine();
			System.out.println("Seu comentario");
			String mensagem = sc.nextLine();
			System.out.println("Id do material");
			Integer id_material = Integer.parseInt(sc.nextLine());
			
			controller.salva(autor, mensagem, id_material);
			break;
			
		case 2:
			em.getTransaction().begin();
			System.out.println("Informe um id válido:");
			int id = Integer.parseInt(sc.nextLine());
			System.out.println("Seu nome:");
			String novoAutor = sc.nextLine();
			System.out.println("Seu comentario");
			String novaMensagem = sc.nextLine();
			
			controller.altera(id, novoAutor, novaMensagem);
			break;
			
		case 3:
			em.getTransaction().begin();
			System.out.println("Informe um id válido para excluir");
			int idParaExcluir = Integer.parseInt(sc.nextLine());
			
			controller.remove(idParaExcluir);
			break;
			
		case 4:
			System.out.println("Lista de comentários disponíveis");
			controller.listaComentariosMateriais();
			break;
			
		case 5:
			em.clear();
			sc.close();
			System.out.println("Programa finalizado com sucesso!");
		
		default:
			System.out.println("Informe uma opção válida.");
		
		}
			
		}while(opcao != 5);
		
	}
	
}
