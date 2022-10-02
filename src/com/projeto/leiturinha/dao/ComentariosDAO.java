package com.projeto.leiturinha.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projeto.leiturinha.model.Comentarios;



public class ComentariosDAO {

	private EntityManager em;
	
	public ComentariosDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salva(Comentarios comentarios) {
		em.persist(comentarios);
		em.getTransaction().commit();
	}
	
	public void altera(Comentarios comentarios) {
		em.merge(comentarios);
		em.getTransaction().commit();
	}
	
	public void remove(Integer id) throws SQLException {
		Comentarios comentarios = em.find(Comentarios.class, id);
		em.remove(comentarios);
		em.getTransaction().commit();
	}
	
	public List<Comentarios> listaComentarios() {
		TypedQuery<Comentarios> query = em.createQuery("from Comentarios", Comentarios.class);
		List<Comentarios> comentarios = query.getResultList();
		return comentarios;
	}

	public Comentarios buscaPorId(Integer id) throws SQLException {
		Comentarios comentarios = em.find(Comentarios.class, id);
	    return comentarios;
	}
	
}
