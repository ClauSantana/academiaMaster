package br.com.academia.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.dao.CategoriaDAO;
import br.com.academia.entidade.Categoria;
import br.com.academia.exception.BusinessException;
import br.com.academia.service.CategoriaService;
import br.com.academia.vo.CategoriaVO;
import br.com.academia.vo.converter.Converter;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired(required=true)
	private CategoriaDAO dao;

	@Override
	@Transactional
	public void salvarCategoria(CategoriaVO categoriaVO) {
		Categoria categoria  = Converter.converterVoParaCategoria(categoriaVO);
		dao.salvarCategoria(categoria);
		
	}

	@Override
	@Transactional
	public void alterarCategoria(CategoriaVO categoriaVO) {
		Categoria categoria = Converter.converterVoParaCategoria(categoriaVO);
		dao.alterarCategoria(categoria);
		
	}

	@Override
	@Transactional
	public void excluirCategoria(long id){
		dao.excluirCategoria(id);
		
	}

	@Override
	public CategoriaVO consultarCategoriaPorId(long id) {
		Categoria categoria = dao.consultarCategoriaPorId(id);
		return Converter.converterCategoriaParaVO(categoria);
	}

	@Override
	public List<CategoriaVO> listarTodasCategorias() {
		List<Categoria> listaCategoria = dao.listarTodasCategorias();
		return Converter.converterListaCategoriaParaListaVo(listaCategoria);
	}
	
	

}
