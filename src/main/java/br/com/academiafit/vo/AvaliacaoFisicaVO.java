package br.com.academiafit.vo;

import java.util.Date;

public class AvaliacaoFisicaVO {

	private Date dataavaliacao;
	private double altura;
	private double peso;
	private double imc;
	private double peito;
	private double cintura;
	private double quadril;
	private double[] braço = new double [2];
	private double [] coxa = new double [2];
	private double [] panturrilha = new double[2];
	
	public Date getDataavaliacao() {
		return dataavaliacao;
	}
	public void setDataavaliacao(Date dataavaliacao) {
		this.dataavaliacao = dataavaliacao;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
	public double getPeito() {
		return peito;
	}
	public void setPeito(double peito) {
		this.peito = peito;
	}
	public double getCintura() {
		return cintura;
	}
	public void setCintura(double cintura) {
		this.cintura = cintura;
	}
	public double getQuadril() {
		return quadril;
	}
	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}
	public double[] getBraço() {
		return braço;
	}
	public void setBraço(double[] braço) {
		this.braço = braço;
	}
	public double[] getCoxa() {
		return coxa;
	}
	public void setCoxa(double[] coxa) {
		this.coxa = coxa;
	}
	public double[] getPanturrilha() {
		return panturrilha;
	}
	public void setPanturrilha(double[] panturrilha) {
		this.panturrilha = panturrilha;
	}
	
}
