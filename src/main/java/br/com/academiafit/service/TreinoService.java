package br.com.academiafit.service;

import java.util.List;

import br.com.academiafit.vo.TreinoVO;

public interface TreinoService {
	public void salvar(TreinoVO avaliacaofisica);
	public String incluir(TreinoVO avaliacaofisica);
	public String excluir (int index);
	public List<TreinoVO> consultarTodos();
	String excluir(TreinoVO avaliacaofisica);
	public List<TreinoVO> listarTodos();
}