package com.projeto.leiturinha.controllers;

import com.projeto.leiturinha.dao.ComentarioMaterialDAO;
import com.projeto.leiturinha.dao.MaterialDAO;
import com.projeto.leiturinha.model.ComentarioMaterial;
import com.projeto.leiturinha.model.Material;

public class ComentarioMaterialController {
	
	private ComentarioMaterialDAO dao;
	private MaterialDAO materialDAO;
	
	public ComentarioMaterialController(ComentarioMaterialDAO dao, MaterialDAO materialDAO) {
		this.dao = dao;
		this.materialDAO = materialDAO;
		
	}
	
	public void salva(String autor, String mensagem,Integer id_material) {
		Material material = materialDAO.buscaPorId(id_material);
		ComentarioMaterial comentarioMaterial = criaComentarioMaterial(autor, mensagem, material);
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
		dao.listaComentariosMaterial()
		.forEach(System.out::println);
	}
	

	private ComentarioMaterial criaComentarioMaterial(String autor, String mensagem, Material material) {
		return new ComentarioMaterial(autor, mensagem, material);
	}

	public void altera(int id, String novoAutor, String novaMensagem) {
		// TODO Auto-generated method stub
		
	}



}

