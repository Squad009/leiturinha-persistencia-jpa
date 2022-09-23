package com.projeto.leiturinha.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projeto.leiturinha.model.Professor;

public class ProfessorDAO {
	
	private EntityManager em;

	public ProfessorDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salva(Professor professor) {
		em.persist(professor); // equivalente ao insert
		em.getTransaction().commit(); //conclui a transação
	}
	
	public void altera(Professor professor) {
		em.merge(professor); //se o objeto já existir, as alterações são feitas com o métdo merge()
		em.getTransaction().commit();
	}
	public List<Professor> listaProfessores() {
		TypedQuery<Professor> query = em.createQuery("from Professor", Professor.class);
		List<Professor> professores = query.getResultList();
		return professores;
	}
	
	public Professor buscarProfessorPorId(Integer id) {
		Professor professor = em.find(Professor.class, id);
		return professor;
	}
	
	public void remove(Integer id) throws SQLException {
		Professor professor = em.find(Professor.class, id);
		em.remove(professor);
		em.getTransaction().commit();
	}
	
}
