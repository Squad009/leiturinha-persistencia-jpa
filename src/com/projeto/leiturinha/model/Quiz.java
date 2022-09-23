package com.projeto.leiturinha.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String enunciado;
	
	@Column(name = "data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name = "opcao_a")
	private String opcaoA;
	
	@Column(name = "opcao_b")
	private String opcaoB;
	
	@Column(name = "opcao_c")
	private String opcaoC;
	
	@Column(name = "opcao_d")
	private String opcaoD;
	
	@Column(name = "opcao_e")
	private String opcaoE;
	
	@Column(name = "opcao_correta")
	private String opcaoCorreta;
	
	//@JoinColumn(unique = true) garante que só pertencerá a um registro
	@ManyToOne
	private Material material;
	
	public Quiz() {
		
	}

	public Quiz(String enunciado, String opcaoA, String opcaoB, String opcaoC, String opcaoD, String opcaoE,
			String opcaoCorreta, Material material) {
		
		this.dataCriacao = Calendar.getInstance().getTime();
		this.enunciado = enunciado;
		this.opcaoA = opcaoA.toUpperCase();
		this.opcaoC = opcaoC.toUpperCase();
		this.opcaoB = opcaoB.toUpperCase();
		this.opcaoD = opcaoD.toUpperCase();
		this.opcaoE = opcaoE.toUpperCase();
		this.opcaoCorreta = opcaoCorreta.toUpperCase();
		this.material = material;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public String getOpcaoA() {
		return opcaoA;
	}

	public void setOpcaoA(String opcaoA) {
		this.opcaoA = opcaoA;
	}

	public String getOpcaoB() {
		return opcaoB;
	}

	public void setOpcaoB(String opcaoB) {
		this.opcaoB = opcaoB;
	}

	public String getOpcaoC() {
		return opcaoC;
	}

	public void setOpcaoC(String opcaoC) {
		this.opcaoC = opcaoC;
	}

	public String getOpcaoD() {
		return opcaoD;
	}

	public void setOpcaoD(String opcaoD) {
		this.opcaoD = opcaoD;
	}

	public String getOpcaoE() {
		return opcaoE;
	}

	public void setOpcaoE(String opcaoE) {
		this.opcaoE = opcaoE;
	}

	public String getOpcaoCorreta() {
		return opcaoCorreta;
	}

	public void setOpcaoCorreta(String opcaoCorreta) {
		this.opcaoCorreta = opcaoCorreta;
	}


	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ id: " + this.id +
				"/ enunciado: " + this.enunciado +
				"/ opcao correta: " + this.opcaoCorreta +
				" }";
	}
	
}
