package com.projeto.leiturinha.controllers;

import com.projeto.leiturinha.dao.ContoDAO;
import com.projeto.leiturinha.dao.EstudanteDAO;
import com.projeto.leiturinha.model.Categoria;
import com.projeto.leiturinha.model.Conto;
import com.projeto.leiturinha.model.Estudante;

public class ContoController {

	private ContoDAO dao;
    private EstudanteDAO estudanteDAO;
    
	public ContoController(ContoDAO dao, EstudanteDAO estudanteDAO) {
		this.dao = dao;
		this.estudanteDAO = estudanteDAO;
	}
	
	public void salva(String titulo, String conteudo, String categoria, Integer id_estudante,
			String imagemCapa) {

		Conto conto = criaConto(titulo, conteudo, categoria, id_estudante, imagemCapa);
		dao.salva(conto);
		System.out.println("Conto salvo com sucesso");
	}

	public void altera(Integer id, String titulo, String conteudo, String imagemCapa) {
		Conto conto = dao.buscaPorId(id);
		conto.setTitulo(titulo);
		conto.setConteudo(conteudo);
		conto.setImagemCapa(imagemCapa);
		dao.altera(conto);
		System.out.println("Conto alterado com sucesso");
	}
	

	public void remove(int idParaExcluir) {
		dao.remove(idParaExcluir);
		System.out.println("Conto excluido com exito");
	}
	
	public void listaContos() {
	   dao.listaContos()
	   	.forEach(System.out::println);
	}
	
	private Conto criaConto(String titulo, String conteudo, String categoria, 
			Integer id_estudante,String imagemCapa) {
		
		Estudante estudante = estudanteDAO.buscarEstudantePorId(id_estudante);
		Categoria categoriaCriada = dao.criaCategoria(categoria);
		
		return new Conto(titulo, conteudo, categoriaCriada, estudante, 
				imagemCapa);
	}
}
