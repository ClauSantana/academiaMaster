package br.com.academiafit.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TREINO")
public class Treino {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="DIASEMANA")
	private char diasemana;
	
	@Column(name="SERIES")
	private int series;
	
	@Column(name="REPETICOES")
	private int repeticoes;

	
	/**
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * 
	 * @param id the is to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return the diasemana
	 */
	public char getDiasemana() {
		return diasemana;
	}
	/**
	 * 
	 * @param diasemana the diasemana to set
	 */
	public void setDiasemana(char diasemana) {
		this.diasemana = diasemana;
	}
	/**
	 * 
	 * @return series
	 */
	public int getSeries() {
		return series;
	}
	/**
	 * 
	 * @param series the series to set
	 */
	public void setSeries(int series) {
		this.series = series;
	}
	/**
	 * 
	 * @return the repeticoes
	 */
	public int getRepeticoes() {
		return repeticoes;
	}
	/**
	 * 
	 * @param repeticoes the repeticoes to set
	 */
	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}
	
	
}
