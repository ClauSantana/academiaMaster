package br.com.academia.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.dao.ProdutoDAO;
import br.com.academia.entidade.Produto;
import br.com.academia.exception.BusinessException;
import br.com.academia.service.ProdutoService;
import br.com.academia.vo.ProdutoVO;
import br.com.academia.vo.converter.Converter;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired(required=true)
	private ProdutoDAO dao;

	@Override
	@Transactional
	public void salvarProduto(ProdutoVO produtoVO) throws BusinessException {
		Produto produto = Converter.converterVoParaProduto(produtoVO);
		
		if(produtoVO.getCategoriaVO().getId() < 1){
			throw new BusinessException("A categoria deve ser informada!");
		}
		
		this.dao.salvarProduto(produto);
		
	}

	@Override
	@Transactional
	public void excluirProduto(long id) {
		this.dao.excluirProduto(id);
		
	}

	@Override
	@Transactional
	public void alterarProduto(ProdutoVO produtoVO) {
		Produto produto = Converter.converterVoParaProduto(produtoVO);
		this.dao.alterarProduto(produto);
		
	}

	@Override
	public List<ProdutoVO> listarTodosProdutos() {
		List<Produto> listaProduto = dao.consultarTodosPodutos();
		return Converter.converterListaProdutoParaListaVo(listaProduto);
	}

	@Override
	public ProdutoVO consultarProdutoPorId(long id) {
		Produto produto = dao.consultarProdutoPorId(id);
		return Converter.converterProdutoParaVO(produto);
	}

	

	
}
