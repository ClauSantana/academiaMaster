package br.com.academiafit.entidade;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends Pessoa {


	@Temporal(TemporalType.DATE)
	@Column(name = "DATA")
	private Date datacontrato;
		
	@Column(name = "ESCOLARIDADE")
	private String escolaridade;

	
	
	public Date getDatacontrato() {
		return datacontrato;
	}
	public void setDatacontrato(Date datacontrato) {
		this.datacontrato = datacontrato;
	}
	/**
	 * 
	 * @return the escolaridade
	 */
	public String getEscolaridade() {
		return escolaridade;
	}
	/**
	 * 
	 * @param escolaridade the escolaridade to set
	 */
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	
}
