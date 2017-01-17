package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.GrupoMuscular;


public interface GrupoMuscularDAO {

		public void salvar(GrupoMuscular grupomuscular);
		public String incluir(GrupoMuscular grupomuscular);
		public String alterar(GrupoMuscular grupomuscular);
		public List<GrupoMuscular> consultarTodos();
		public List<GrupoMuscular> listarTodos();

}