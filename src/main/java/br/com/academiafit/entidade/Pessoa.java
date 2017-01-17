package br.com.academiafit.entidade;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name="CPF")
	private String cpf;

	@Column( name ="NOME", length=50)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column (columnDefinition = "DATADENASCIMENTO", length=10)
	private Date dtnascimento; 

	@Column (columnDefinition = "ENDERECO", length=50)
	private String end;

	@Column (columnDefinition="BAIRRO", length=50)
	private String bairro;

	@Column (columnDefinition = "CIDADE", length=50)
	private String cidade;

	@Column (columnDefinition= "ESTADO", length=50)
	private String estado;

	@Column (columnDefinition= "TELEFONE", length=50)
	private String fone;

	@Column (columnDefinition= "SEXO", length=1)
	private char sexo;

	@Column (columnDefinition= "ATIVO", length=10)
	private boolean ativo;

	/**
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * 
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * 
	 * @return the dtnascimento
	 */
	public Date getDtnascimento() {
		return dtnascimento;
	}
	/**
	 * 
	 * @param dtnascimento the dtnascimento to set
	 */
	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}
	/**
	 * 
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}
	/**
	 * 
	 * @param end the end to set
 	 */
	public void setEnd(String end) {
		this.end = end;
	}
	/**
	 * 
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * 
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * 
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * 
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * 
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * 
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * 
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}
	/**
	 * 
	 * @param fone the fone to set
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}
	/**
	 * 
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}
	/**
	 * 
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	/**
	 * 
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}
	/**
	 * 
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
	
}
