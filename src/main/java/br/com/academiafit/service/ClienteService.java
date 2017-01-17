package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.ClienteVO;


public interface ClienteService {
	
	public void salvar(ClienteVO cliente);
	public String incluir(ClienteVO cliente);
	public String excluir (int index);
	public List<ClienteVO> consultarTodos();
	String excluir(ClienteVO cliente);
	public List<ClienteVO> listarTodos();


}
