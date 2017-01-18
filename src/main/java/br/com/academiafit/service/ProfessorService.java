package br.com.academiafit.service;
import java.util.List;


import br.com.academiafit.vo.ProfessorVO;

public interface ProfessorService {
	
	
	public String incluir(ProfessorVO professor);
	public String excluir(ProfessorVO professor);
	public String alterar (ProfessorVO professor);
	public List<ProfessorVO> listarTodos();


}
