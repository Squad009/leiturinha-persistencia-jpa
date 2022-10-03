package com.projeto.leiturinha.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.projeto.leiturinha.controllers.Estudante_ConteudoController;
import com.projeto.leiturinha.dao.Estudante_ConteudoDAO;
import com.projeto.leiturinha.utils.JPAUtil;

public class Estudante_ConteudoTeste {
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	int opcao;
	
	EntityManager em = JPAUtil.getEntityManager();
	Estudante_ConteudoDAO dao = new Estudante_ConteudoDAO(em);
	Estudante_ConteudoController controller = new Estudante_ConteudoController(dao);
	
	
	do {
		
		System.out.println();
		System.out.println("*******************************************************************");
		System.out.println("***************************CRUD Estudante_Conteudo***********************");
		System.out.println("1 - Adicionar / 2 - remover / 3 - listar / 4 - sair");
		opcao = Integer.parseInt(sc.nextLine());
		
	switch(opcao) {
		
		case 1: 
			em.getTransaction().begin();
			System.out.println("Id do estudante: ");
			Integer idEstudante = Integer.valueOf(sc.nextLine());
			System.out.println("Id do material: ");
			Integer idConteudo = Integer.valueOf(sc.nextLine());
			
			controller.salva(idEstudante, idConteudo);
			break;
			
		case 2:
			em.getTransaction().begin();
			System.out.println("Informe um id valido para excluir um registro Estudante_Conteudo");
			Integer idParaExcluir = Integer.valueOf(sc.nextLine());
			
			controller.remove(idParaExcluir);
			break;
			
		case 3:
			System.out.println("Lista de registros de Estudante_Conteudo");
			controller.listaProfessores();
			break;
		
		case 4:
			em.clear();
			sc.close();
			System.out.println("Programa finalizado com sucesso!");
			break;
			
		default:
			System.out.println("Informe uma opcao valida.");
			
		}
		
	}while(opcao != 4);
	
	
}

}
