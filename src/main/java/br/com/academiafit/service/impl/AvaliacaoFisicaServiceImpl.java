package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.AvaliacaoFisicaDAO;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.AvaliacaoFisicaService;
import br.com.academiafit.vo.AvaliacaoFisicaVO;
import br.com.academiafit.vo.converter.ConverterAvaliacaoFisica;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService{
	@Autowired(required=true)
	private AvaliacaoFisicaDAO dao;
	
	@Transactional
	public void incluir(AvaliacaoFisicaVO avaliacaofisica) {
		avaliacaofisica.setImc();
		String msg = new String (dao.incluir(ConverterAvaliacaoFisica.ConverterAvaliacaoFisicaVoParaAvaliacaoFisica(avaliacaofisica)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));	
	}

	@Transactional
	public List<AvaliacaoFisicaVO> listarTodos() {
		return ConverterAvaliacaoFisica.ConverterAvaliacaoFisicaListaAvaliacaoFisicaParaListaVo(dao.consultarTodos());
	}

	@Transactional
	public void excluir(AvaliacaoFisicaVO avaliacaofisica) {
		String msg = new String (dao.excluir(ConverterAvaliacaoFisica.ConverterAvaliacaoFisicaVoParaAvaliacaoFisica(avaliacaofisica).getId()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}

	@Transactional
	public void alterar(AvaliacaoFisicaVO avaliacaofisica) {
		String msg = new String (dao.alterar(ConverterAvaliacaoFisica.ConverterAvaliacaoFisicaVoParaAvaliacaoFisica(avaliacaofisica)));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}

	@Transactional
	public void consultar(AvaliacaoFisicaVO avaliacaofisica) {
		try{
			dao.consultar(ConverterAvaliacaoFisica.ConverterAvaliacaoFisicaVoParaAvaliacaoFisica(avaliacaofisica).getId());
		}catch(BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(exception.getMessage()));
		}
	}
}
