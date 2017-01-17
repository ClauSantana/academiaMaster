package br.com.academiafit.vo;

import java.io.Serializable;
import java.util.Date;

public class ClienteVO implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	private double peso;
	private double altura;
	private Date datacadastro;
	private char desenvolvimento;
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public Date getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
	public char getDesenvolvimento() {
		return desenvolvimento;
	}
	public void setDesenvolvimento(char desenvolvimento) {
		this.desenvolvimento = desenvolvimento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
