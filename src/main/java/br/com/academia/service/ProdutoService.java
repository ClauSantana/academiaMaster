package br.com.academia.service;

import java.util.List;

import br.com.academia.exception.BusinessException;
import br.com.academia.vo.ProdutoVO;

/**
 * Interface de negócio da entidade Produto
 * @author MARCOS
 *
 */
public interface ProdutoService {

	public void salvarProduto(ProdutoVO produtoVO) throws BusinessException;
	public void excluirProduto(long id);
	public void alterarProduto(ProdutoVO produtoVO);
	public List<ProdutoVO> listarTodosProdutos();
	public ProdutoVO consultarProdutoPorId(long id);
	
}
