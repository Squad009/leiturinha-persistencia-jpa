package com.projeto.leiturinha.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projeto.leiturinha.model.Material;

public class MaterialDAO {
	
	private EntityManager em;
	
	public MaterialDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salva(Material material) {
		em.persist(material);
		em.getTransaction().commit();
	}
	
	public void altera(Material material) {
		em.merge(material);
		em.getTransaction().commit();
	}
	
	public void remove(Integer id) {
		Material material = em.find(Material.class, id);
		em.remove(material);
		em.getTransaction().commit();
	}
	
	public List<Material> listaMateriais() {
		TypedQuery<Material> query = em.createQuery("from Material", Material.class);
		List<Material> materias = query.getResultList();
		return materias;
	}

	public Material buscaPorId(Integer id) {
		Material material = em.find(Material.class, id);
	    return material;
	}
	
}
