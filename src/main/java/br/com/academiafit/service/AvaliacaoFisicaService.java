package br.com.academiafit.service;

import java.util.List;
import br.com.academiafit.vo.AvaliacaoFisicaVO;


public interface AvaliacaoFisicaService {
	public void incluir(AvaliacaoFisicaVO avaliacaofisica);
	public void excluir (AvaliacaoFisicaVO avaliacaofisica);
	public void alterar(AvaliacaoFisicaVO avaliacaofisica);
	public List<AvaliacaoFisicaVO> listarTodos();
	void consultar(AvaliacaoFisicaVO avaliacaofisica);
}