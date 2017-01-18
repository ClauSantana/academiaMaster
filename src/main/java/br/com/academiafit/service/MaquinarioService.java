package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.MaquinarioVO;


public interface MaquinarioService {
	
	
	public String incluir(MaquinarioVO maquinario);
	public String excluir(MaquinarioVO maquinario);
	public String alterar (MaquinarioVO maquinario);
	public List<MaquinarioVO> listarTodos();


}
