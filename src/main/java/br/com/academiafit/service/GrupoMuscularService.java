package br.com.academiafit.service;
import java.util.List;


import br.com.academiafit.vo.GrupoMuscularVO;



public interface GrupoMuscularService {
	
	
	public String incluir(GrupoMuscularVO grupomuscular);
	public String excluir(GrupoMuscularVO grupomuscular);
	public String alterar (GrupoMuscularVO grupomuscular);
	public List<GrupoMuscularVO> listarTodos();


}
