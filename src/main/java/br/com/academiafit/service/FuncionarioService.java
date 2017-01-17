package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.FuncionarioVO;


public interface FuncionarioService {
	
	public void salvar(FuncionarioVO funcionario);
	public String incluir(FuncionarioVO funcionario);
	public String excluir (int index);
	public List<FuncionarioVO> consultarTodos();
	String excluir(FuncionarioVO funcionario);
	public List<FuncionarioVO> listarTodos();


}
