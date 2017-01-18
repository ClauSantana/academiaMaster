package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.ClienteVO;
import br.com.academiafit.vo.MaquinarioVO;


public interface ClienteService {
	
	
	public void incluir(ClienteVO cliente);
	public void excluir(ClienteVO cliente);
	public void alterar (ClienteVO cliente);
	public List<ClienteVO> listarTodos();
	
	

}
