package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.AvaliacaoFisicaVO;


public interface AvaliacaoFisicaService {
	
	public void salvar(AvaliacaoFisicaVO avaliacaofisica);
	public String incluir(AvaliacaoFisicaVO avaliacaofisica);
	public String excluir (int index);
	public List<AvaliacaoFisicaVO> consultarTodos();
	String excluir(AvaliacaoFisicaVO avaliacaofisica);
	public List<AvaliacaoFisicaVO> listarTodos();

	

}
