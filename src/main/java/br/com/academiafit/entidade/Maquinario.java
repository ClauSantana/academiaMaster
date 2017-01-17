package br.com.academiafit.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAQUINARIO")
public class Maquinario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="NOME")
	private char nome;

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
	 * @return the nome
	 */
	public char getNome() {
		return nome;
	}
	/**
	 * 
	 * @param nome the nome to sets
	 */
	public void setNome(char nome) {
		this.nome = nome;
	}
	
	
}
