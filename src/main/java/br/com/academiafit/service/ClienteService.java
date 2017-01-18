package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.ClienteVO;
import br.com.academiafit.vo.MaquinarioVO;


public interface ClienteService {
	
	
	public String incluir(ClienteVO cliente);
	public String excluir(ClienteVO cliente);
	public String alterar (ClienteVO cliente);
	public List<ClienteVO> listarTodos();
	
	

}
