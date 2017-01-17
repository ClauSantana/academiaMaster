package br.com.academiafit.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="AVALIACAO_FISICA")
public class AvaliacaoFisica{	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@OneToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	@Column(name="DATAAVALIACAO")
	private Date dataavaliacao;
	
	@Column(name="ALTURA")
	private double altura;
	
	@Column(name="PESO")
	private double peso;
	
	@Column(name="IMC")
	private double imc;
	
	@Column(name="PEITO")
	private double peito;
	
	@Column(name="CINTURA")
	private double cintura;
	
	@Column(name="QUADRIL")
	private double quadril;
	
	@Column(name="BRACO")
	private double braco;
	
	@Column(name="COXA")
	private double coxa;

	@Column(name="PANTURRILHA")
	private double panturrilha;

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
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * 
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * 
	 * @return the dataavaliacao
	 */
	public Date getDataavaliacao() {
		return dataavaliacao;
	}
	/**
	 * 
	 * @param dataavaliacao the dataavaliacao to set
	 */
	public void setDataavaliacao(Date dataavaliacao) {
		this.dataavaliacao = dataavaliacao;
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
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * 
	 * @param peso the pese to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
	 * 
	 * @return the imc
	 */
	public double getImc() {
		return imc;
	}
	/**
	 * 
	 * @param imc the imc to set
	 */
	public void setImc(double imc) {
		this.imc = imc;
	}
	/**
	 * 
	 * @return the peito
	 */
	public double getPeito() {
		return peito;
	}
	/**
	 * 
	 * @param peito the peito to set
	 */
	public void setPeito(double peito) {
		this.peito = peito;
	}
	/** 
	 * 
	 * @return the cintura
	 */
	public double getCintura() {
		return cintura;
	}
	/**
	 * 
	 * @param cintura the cintura to set
	 */
	public void setCintura(double cintura) {
		this.cintura = cintura;
	}

	/**
	 * 
	 * @return the quadril
	 */
	public double getQuadril() {
		return quadril;
	}

	/**
	 * 
	 * @param quadril the quadril to set
	 */
	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}
	
	/**
	 * 
	 * @return the braco
	 */
	public double getBraco() {
		return braco;
	}
	/**
	 * 
	 * @param braco the braco to set
	 */
	public void setBraco(double braco) {
		this.braco = braco;
	}
	/**
	 * 
	 * @return the coxa
	 */
	public double getCoxa() {
		return coxa;
	}
	/**
	 * 
	 * @param coxa the coxa to set
	 */
	public void setCoxa(double coxa) {
		this.coxa = coxa;
	}
	/**
	 * 
	 * @return the panturrilha
	 */
	public double getPanturrilha() {
		return panturrilha;
	}
	/**
	 * 
	 * @param panturrilha the panturrilha to set
	 */
	public void setPanturrilha(double panturrilha) {
		this.panturrilha = panturrilha;
	}
	
	
	
}
