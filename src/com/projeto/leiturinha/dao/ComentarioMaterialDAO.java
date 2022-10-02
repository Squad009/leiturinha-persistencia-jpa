package com.projeto.leiturinha.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projeto.leiturinha.model.ComentarioMaterial;

public class ComentarioMaterialDAO {
	
private EntityManager em;
	
	public ComentarioMaterialDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salva(ComentarioMaterial comentarioMaterial) {
		em.persist(comentarioMaterial);
		em.getTransaction().commit();
	}
	
	public void altera(ComentarioMaterial comentarioMaterial) {
		em.merge(comentarioMaterial);
		em.getTransaction().commit();
	}
	
	public void remove(Integer id) {
		ComentarioMaterial comentarioMaterial = em.find(ComentarioMaterial.class, id);
		em.remove(comentarioMaterial);
		em.getTransaction().commit();
	}
	
	public List<ComentarioMaterial> listaComentarioMaterial() {
		TypedQuery<ComentarioMaterial> query = em.createQuery("from ComentarioMaterial", ComentarioMaterial.class);
		List<ComentarioMaterial> comentariosMaterial = query.getResultList();
		return comentariosMaterial;
	}

	public ComentarioMaterial buscaPorId(Integer id) {
		ComentarioMaterial comentarioMaterial = em.find(ComentarioMaterial.class, id);
	    return comentarioMaterial;
	}

}
