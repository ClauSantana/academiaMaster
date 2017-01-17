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
	private Date data;
		
	@Column(name = "ESCOLARIDADE")
	private char escolaridade;

	
	/**
	 * 
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * 
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * 
	 * @return the escolaridade
	 */
	public char getEscolaridade() {
		return escolaridade;
	}
	/**
	 * 
	 * @param escolaridade the escolaridade to set
	 */
	public void setEscolaridade(char escolaridade) {
		this.escolaridade = escolaridade;
	}
	
}
