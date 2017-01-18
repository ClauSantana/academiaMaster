package br.com.academiafit.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESSOR")
public class Professor extends Funcionario{

	@Column(name="HORARIO")
	private String horario;

	/**
	 * 
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}
	/**
	 * 
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	
}
