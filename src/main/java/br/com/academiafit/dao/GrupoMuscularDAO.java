package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.GrupoMuscular;


public interface GrupoMuscularDAO {

		public String incluir(GrupoMuscular grupomuscular);
		public String alterar(GrupoMuscular grupomuscular);
		public String excluir(int index);
		public List<GrupoMuscular> consultarTodos();
		

}