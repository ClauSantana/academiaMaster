package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.TreinoDAO;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.TreinoService;
import br.com.academiafit.vo.TreinoVO;
import br.com.academiafit.vo.converter.ConverterTreino;

@Service
public class TreinoServiceImpl implements TreinoService{
	
	@Autowired(required=true)
	private TreinoDAO dao;
	
	@Override
	@Transactional
	public void incluir(TreinoVO treino) {
		String msg = new String (dao.incluir(ConverterTreino.ConverterTreinoVoParaTreino(treino)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));	
	}

	@Override
	public List<TreinoVO> listarTodos() {
		return ConverterTreino.ConverterTreinoListaTreinoParaListaVo(dao.consultarTodos());
	}
	
	@Override
	@Transactional
	public void excluir(TreinoVO treino) {
		String msg = new String (dao.excluir(ConverterTreino.ConverterTreinoVoParaTreino(treino).getId()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	@Override
	@Transactional
	public void alterar(TreinoVO treino) {
		String msg = new String (dao.alterar(ConverterTreino.ConverterTreinoVoParaTreino(treino)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}

	@Override
	public void consultar(TreinoVO treino) {
		try{
			dao.consultar(ConverterTreino.ConverterTreinoVoParaTreino(treino).getId());
		}catch(BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(exception.getMessage()));
		}
	}
}
