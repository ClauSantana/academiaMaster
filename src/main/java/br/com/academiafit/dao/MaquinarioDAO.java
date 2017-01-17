package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.Maquinario;


public interface MaquinarioDAO {

		public void salvar(Maquinario maquinario);
		public String incluir(Maquinario maquinario);
		public String alterar(Maquinario maquinario);
		public String excluir (int index);
		public List<Maquinario> consultarTodos();
		public List<Maquinario> listarTodos();

}