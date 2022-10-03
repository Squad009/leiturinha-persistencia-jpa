package com.projeto.leiturinha.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projeto.leiturinha.model.Estudante_Conteudo;

public class Estudante_ConteudoDAO {

private EntityManager em;
	
	public Estudante_ConteudoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salva(Estudante_Conteudo ec) {
		em.persist(ec);
		em.getTransaction().commit();
	}
	
	public void altera(Estudante_Conteudo ec) {
		em.merge(ec);
		em.getTransaction().commit();
	}
	
	public void remove(Integer id) {
		Estudante_Conteudo ec = em.find(Estudante_Conteudo.class, id);
		em.remove(ec);
		em.getTransaction().commit();
	}
	
	public List<Estudante_Conteudo> listaEstudante_Conteudo() {
		TypedQuery<Estudante_Conteudo> query = em.createQuery("from Estudante_Conteudo", Estudante_Conteudo.class);
		return query.getResultList();
	}
	
	public Estudante_Conteudo buscarPorId(Integer id) {
		Estudante_Conteudo ec = em.find(Estudante_Conteudo.class, id);
		return ec;
	}
}
