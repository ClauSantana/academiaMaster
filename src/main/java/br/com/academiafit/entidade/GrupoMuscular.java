package br.com.academiafit.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GRUPOMUSCULAR")	
public class GrupoMuscular {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	//@OneToOne
	//@JoinColumn(name="")
	//private Cliente cliente;
	
	@Column(name="MUSCULO")
	private char musculo;
	
	@Column(name="EXERCICIOS")
	private char exercicios;
	
	
	/**
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * 
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return the musculo
	 */
	public char getMusculo() {
		return musculo;
	}
	/**
	 * 
	 * @param musculo the musculo to set
	 */
	public void setMusculo(char musculo) {
		this.musculo = musculo;
	}
	/**
	 * 
	 * @return the exercicio
	 */
	public char getExercicios() {
		return exercicios;
	}
	/**
	 * 
	 * @param exercicios the exercicios to set
	 */
	public void setExercicios(char exercicios) {
		this.exercicios = exercicios;
	}
	
	
	
	
	
}
