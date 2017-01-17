package br.com.academiafit.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Pessoa {

		@Column(name = "PESO")
		private double peso;
		
		@Column(name = "ALTURA")
		private double altura;
		
		@Temporal(TemporalType.DATE)
		@Column(name = "DATACADASTRO")
		private Date datacadastro;
		
		@Column(name = "DESENVOLVIMENTO")
		private char desenvolvimento;


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
		public char getDesenvolvimento() {
			return desenvolvimento;
		}
		/**
		 * 
		 * @param desenvolvimento the desenvolvimento to set
		 */
		public void setDesenvolvimento(char desenvolvimento) {
			this.desenvolvimento = desenvolvimento;
		}
		
		
}
