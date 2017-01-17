package br.com.academiafit.service;
import java.util.List;


import br.com.academiafit.vo.GrupoMuscularVO;



public interface GrupoMuscularService {
	
	public void salvar(GrupoMuscularVO grupomuscular);
	public String incluir(GrupoMuscularVO grupomuscular);
	public String excluir (int index);
	public List<GrupoMuscularVO> consultarTodos();
	String excluir(GrupoMuscularVO grupomuscular);
	public List<GrupoMuscularVO> listarTodos();


}
