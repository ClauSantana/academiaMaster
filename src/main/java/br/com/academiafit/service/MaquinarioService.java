package br.com.academiafit.service;
import java.util.List;
import br.com.academiafit.vo.MaquinarioVO;


public interface MaquinarioService {
	public void salvar(MaquinarioVO maquinario);
	public String incluir(MaquinarioVO maquinario);
	public String excluir (int index);
	public List<MaquinarioVO> consultarTodos();
	String excluir(MaquinarioVO maquinario);
	public List<MaquinarioVO> listarTodos();


}
