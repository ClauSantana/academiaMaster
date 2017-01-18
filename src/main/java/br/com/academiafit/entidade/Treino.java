package br.com.academiafit.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="treino")
public class Treino {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="diasemana")
	private char diasemana;
	
	@Column(name="series")
	private int series;
	
	@Column(name="repeticoes")
	private int repeticoes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public char getDiasemana() {
		return diasemana;
	}

	public void setDiasemana(char diasemana) {
		this.diasemana = diasemana;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public int getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}
	
}
