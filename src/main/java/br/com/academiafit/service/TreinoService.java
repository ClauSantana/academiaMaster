package br.com.academiafit.service;

import java.util.List;

import br.com.academiafit.vo.TreinoVO;

public interface TreinoService {
	
	public void incluir(TreinoVO treino);
	public void excluir (TreinoVO treino);
	public void alterar(TreinoVO treino);
	public List<TreinoVO> listarTodos();
	void consultar(TreinoVO treino);
}