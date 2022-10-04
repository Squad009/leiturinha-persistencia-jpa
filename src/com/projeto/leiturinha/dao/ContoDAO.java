package com.projeto.leiturinha.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projeto.leiturinha.model.Categoria;
import com.projeto.leiturinha.model.Conto;

public class ContoDAO {
	
	private EntityManager em;
	
	public ContoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salva(Conto conto) {
		em.getTransaction().begin();
		em.persist(conto);
		em.getTransaction().commit();
	}
	
	public void altera(Conto conto) {
		em.merge(conto);
		em.getTransaction().commit();
	}
	
	public void remove(Integer id) {
		Conto conto = em.find(Conto.class, id);
		em.remove(conto);
		em.getTransaction().commit();
	}
	
	public List<Conto> listaContos() {
		TypedQuery<Conto> query = em.createQuery("from Conto", Conto.class);
		List<Conto> contos = query.getResultList();
		return contos;
	}

	public Conto buscaPorId(Integer id) {
		Conto conto = em.find(Conto.class, id);
	    return conto;
	}

	public Categoria criaCategoria(String nome) {
		Categoria categoria = new Categoria(nome);
		em.persist(categoria);
		em.getTransaction().commit();
		return categoria;
	}
}
