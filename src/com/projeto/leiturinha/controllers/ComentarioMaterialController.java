package com.projeto.leiturinha.controllers;

import com.projeto.leiturinha.dao.ComentarioMaterialDAO;
import com.projeto.leiturinha.model.ComentarioMaterial;

public class ComentarioMaterialController {
	
	private ComentarioMaterialDAO dao;
	
	public ComentarioMaterialController(ComentarioMaterialDAO dao) {
		this.dao = dao;
	}
	
	public void salva(String autor, String mensagem) {
		ComentarioMaterial comentarioMaterial = criaComentarioMaterial(autor, mensagem);
		dao.salva(comentarioMaterial);
		System.out.println("Comentário salvo com sucesso no material!");
	}
	

	public void altera(Integer id, String autor, String mensagem) {
		ComentarioMaterial comentarioMaterial = dao.buscaPorId(id);
		comentarioMaterial.setAutor(autor);
		comentarioMaterial.setMensagem(mensagem);
		dao.altera(comentarioMaterial);
		System.out.println("Comentário alterado com sucesso");
	}
	
	public void remove(int idParaExcluir){
		dao.remove(idParaExcluir);
		System.out.println("Comentário excluído com êxito");
	}
	
	public void listaComentariosMateriais(){
		dao.listaComentarioMaterial()
		.forEach(System.out::println);
	}
	

	private ComentarioMaterial criaComentarioMaterial(String autor, String mensagem) {
		return new ComentarioMaterial(autor,mensagem);
	}

	public void altera(int id, String novoAutor, String novaMensagem) {
		// TODO Auto-generated method stub
		
	}



}
