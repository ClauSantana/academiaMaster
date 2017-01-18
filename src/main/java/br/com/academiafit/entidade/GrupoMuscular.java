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
	private String musculo;
	
	@Column(name="EXERCICIOS")
	private String exercicios;
	
	
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
	public String getMusculo() {
		return musculo;
	}
	/**
	 * 
	 * @param musculo the musculo to set
	 */
	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}
	/**
	 * 
	 * @return the exercicio
	 */
	public String getExercicios() {
		return exercicios;
	}
	/**
	 * 
	 * @param exercicios the exercicios to set
	 */
	public void setExercicios(String exercicios) {
		this.exercicios = exercicios;
	}
	
	
	
	
	
}
