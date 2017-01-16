package br.com.academia.vo;

import java.math.BigDecimal;

public class ProdutoVO {

	private long id;
	private String descricao;
	private BigDecimal valor;
	private CategoriaVO categoriaVO;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public CategoriaVO getCategoriaVO() {
		return categoriaVO;
	}
	public void setCategoriaVO(CategoriaVO categoriaVO) {
		this.categoriaVO = categoriaVO;
	}
	
	
	
	
	
}
