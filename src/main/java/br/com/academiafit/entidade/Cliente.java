package br.com.academiafit.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa{
	
	@Column(name = "PESO")
	private double peso;

	@Column(name = "ALTURA")
	private double altura;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATACADASTRO")
	private Date datacadastro;

	@Column(name = "DESENVOLVIMENTO")
	private String desenvolvimento;
	
	@OneToMany
	private List<AvaliacaoFisica> listaAvaliacaoFisica;
	
	@OneToMany
	private List<Treino> listaTreino;

	/**
	 * 
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * 
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * 
	 * @return the altura
	 */
	public double getAltura() {
		return altura;
	}
	/**
	 * 
	 * @param altura the altura to set
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}
	/**
	 * 
	 * @return the datacadastro
	 */
	public Date getDatacadastro() {
		return datacadastro;
	}
	/**
	 * 
	 * @param datacadastro the datacadastro to set
	 */
	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
	/**
	 * 
	 * @return desenvolvimento
	 */
	public String getDesenvolvimento() {
		return desenvolvimento;
	}
	/**
	 * 
	 * @param string the desenvolvimento to set
	 */
	public void setDesenvolvimento(String string) {
		this.desenvolvimento = string;
	}
	/**
	 * @return the listaAvaliacaoFisica
	 */
	public List<AvaliacaoFisica> getListaAvaliacaoFisica() {
		return listaAvaliacaoFisica;
	}
	/**
	 * @param listaAvaliacaoFisica the listaAvaliacaoFisica to set
	 */
	public void setListaAvaliacaoFisica(List<AvaliacaoFisica> listaAvaliacaoFisica) {
		this.listaAvaliacaoFisica = listaAvaliacaoFisica;
	}
	/**
	 * @return the listaTreino
	 */
	public List<Treino> getListaTreino() {
		return listaTreino;
	}
	/**
	 * @param listaTreino the listaTreino to set
	 */
	public void setListaTreino(List<Treino> listaTreino) {
		this.listaTreino = listaTreino;
	}
	
}
