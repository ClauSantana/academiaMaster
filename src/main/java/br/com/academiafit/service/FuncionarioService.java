package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.FuncionarioVO;



public interface FuncionarioService {
	
	
	public void incluir(FuncionarioVO funcionario);
	public void excluir(FuncionarioVO funcionario);
	public void alterar (FuncionarioVO funcionario);
	public List<FuncionarioVO> listarTodos();


}
