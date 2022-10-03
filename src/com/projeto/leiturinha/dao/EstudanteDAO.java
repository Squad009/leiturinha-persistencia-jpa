package com.projeto.leiturinha.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projeto.leiturinha.model.Estudante;

public class EstudanteDAO {

	private EntityManager em;

	public EstudanteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salva(Estudante estudante) {
		em.persist(estudante); // equivalente ao insert
		em.getTransaction().commit(); //conclui a transacao
	}
	
	public void altera(Estudante estudante) {
		em.merge(estudante); //se o objeto ja existir, as alteracoes sao feitas com o metdo merge()
		em.getTransaction().commit();
	}
	public List<Estudante> listaEstudantes() {
		TypedQuery<Estudante> query = em.createQuery("from Estudante", Estudante.class);
		List<Estudante> estudantes = query.getResultList();
		return estudantes;
	}
	
	public Estudante buscarEstudantePorId(Integer id) {
		Estudante estudante = em.find(Estudante.class, id);
		return estudante;
	}
	
	public void remove(Integer id) throws SQLException {
		Estudante estudante = em.find(Estudante.class, id);
		em.remove(estudante);
		em.getTransaction().commit();
	}
	
}