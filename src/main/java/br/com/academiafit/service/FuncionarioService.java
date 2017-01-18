package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.FuncionarioVO;



public interface FuncionarioService {
	
	
	public String incluir(FuncionarioVO funcionario);
	public String excluir(FuncionarioVO funcionario);
	public String alterar (FuncionarioVO funcionario);
	public List<FuncionarioVO> listarTodos();


}
