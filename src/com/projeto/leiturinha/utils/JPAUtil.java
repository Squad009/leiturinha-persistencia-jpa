package com.projeto.leiturinha.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static String UNIT = "leiturinha"; // unidade de configura��o do nosso projeto que definimos no arquivo persistence (<persistence-unit name="leiturinha">) 
	
	
    private static EntityManager em;
    
	public static EntityManager getEntityManager() {
		// cria a inst�ncia de um factory baseado no arquivo persistence.xml que criamos
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT); 
		if(em == null) em = emf.createEntityManager(); // retorna um EntityManager para fazermos nossas opera��es no banco
		
		return em;
	}
}
