package com.projeto.leiturinha.controllers;

import com.projeto.leiturinha.dao.MaterialDAO;
import com.projeto.leiturinha.dao.ProfessorDAO;
import com.projeto.leiturinha.model.Material;
import com.projeto.leiturinha.model.Professor;

public class MaterialController {

	private MaterialDAO dao;
    private ProfessorDAO professorDAO;
    
	public MaterialController(MaterialDAO dao, ProfessorDAO professorDAO) {
		this.dao = dao;
		this.professorDAO = professorDAO;
	}
	
	public void salva(String titulo, String conteudo, Integer id_professor) {
		Professor professor = professorDAO.buscarProfessorPorId(id_professor);
		Material material = criaMaterial(titulo,conteudo, professor);
		dao.salva(material);
		System.out.println("Material salvo com sucesso");
	}

	public void altera(Integer id, String titulo, String conteudo) {
		Material material = dao.buscaPorId(id);
		material.setTitulo(titulo);
		material.setConteudo(conteudo);
		dao.altera(material);
		System.out.println("Material alterado com sucesso");
	}
	

	public void remove(int idParaExcluir) {
		dao.remove(idParaExcluir);
		System.out.println("Material excluído com êxito");
	}
	
	public void listaMateriais() {
	   dao.listaMateriais()
	   	.forEach(System.out::println);
	}
	
	private Material criaMaterial(String titulo, String conteudo, Professor professor) {
		return new Material(titulo, conteudo, professor);
	}
}
