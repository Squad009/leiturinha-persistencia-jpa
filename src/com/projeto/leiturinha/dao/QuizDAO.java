package com.projeto.leiturinha.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projeto.leiturinha.model.Quiz;

public class QuizDAO {

	private EntityManager em;
	
	public QuizDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salva(Quiz quiz) {
		em.persist(quiz);
		em.getTransaction().commit();
		
	}
	
	public void altera(Quiz quiz) {
		em.merge(quiz);
		em.getTransaction().commit();
	}
	
	public void remove(Integer id) {
		Quiz quiz = em.find(Quiz.class, id);
		em.remove(quiz);
		em.getTransaction().commit();
	}
	
	public List<Quiz> listaQuizzes() {
		TypedQuery<Quiz> query = em.createQuery("from Quiz", Quiz.class);
		return query.getResultList();
	}
	
	public Quiz buscarPorId(Integer id) {
		Quiz quiz = em.find(Quiz.class, id);
		return quiz;
	}
}
