package com.projeto.leiturinha.utils;

public class ViewUtil {
	
	public static void introView(String nomeEntidade) {
		
		String stars = "";
		
		for(int i = 0; i < nomeEntidade.length(); i++) {
			stars+= "*";
		}
		
		createView(nomeEntidade, stars);
	}
	
	private static void createView(String nomeEntidade, String stars) {
		System.out.println();
		System.out.println("**************************************************"+stars);
		System.out.println("***************************"+nomeEntidade +"***********************");
		System.out.println("1 - Adicionar / 2 - alterar / 3 - remover / 4 - listar / 5 - sair");
	}

}
