package br.com.academiafit.service;
import java.util.List;

import br.com.academiafit.vo.ProfessorVO;

public interface ProfessorService {
	public void salvar(ProfessorVO professor);
	public String incluir(ProfessorVO professor);
	public String excluir (int index);
	public List<ProfessorVO> consultarTodos();
	String excluir(ProfessorVO professor);
	public List<ProfessorVO> listarTodos();


}
