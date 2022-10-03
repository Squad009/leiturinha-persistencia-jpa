package com.projeto.leiturinha.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.projeto.leiturinha.utils.DateUtil;

@Entity
public class Estudante_Conteudo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_acesso")
	private Date horaAcesso;
	
	@Column(name = "id_estudante")
	private Integer idEstudante;
	
	@Column(name = "id_material")
	private Integer idMaterial;
	
	public Estudante_Conteudo() {
		
	}
	
	public Estudante_Conteudo(Integer idEstudante, Integer idMaterial) {
		this.idEstudante = idEstudante;
		this.idMaterial = idMaterial;
		this.horaAcesso = Calendar.getInstance().getTime();
	}

	public Integer getIdEstudante() {
		return idEstudante;
	}

	public void setIdEstudante(Integer idEstudante) {
		this.idEstudante = idEstudante;
	}

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Date getHoraAcesso() {
		return horaAcesso;
	}
	
	@Override
	public String toString() {
		return "Id estudante = " + this.idEstudante + "\n" +
			   "Id conteudo = " + this.idMaterial + "\n" +
			   "Hora de acesso = " + DateUtil.fullDateToString(horaAcesso) + "\n\n";
	}
	
}
