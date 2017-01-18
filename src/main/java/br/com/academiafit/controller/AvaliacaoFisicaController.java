package br.com.academiafit.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.academiafit.service.AvaliacaoFisicaService;
import br.com.academiafit.vo.AvaliacaoFisicaVO;

@Controller("avaliacaoFisicaMbean")
@Scope("session")
public class AvaliacaoFisicaController {
	
	private AvaliacaoFisicaService avaliacaoFisicaService;
	private List<AvaliacaoFisicaVO> listaAvaliacaoFisicaVO;
	private AvaliacaoFisicaVO avaliacaoFisica = new AvaliacaoFisicaVO();
	
	@Autowired
	public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService){
		this.avaliacaoFisicaService = avaliacaoFisicaService;
	}
	
	@PostConstruct
	public void init(){
		//System.out.println(listaAvaliacaoFisicaVO);
	}

	public AvaliacaoFisicaVO getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(AvaliacaoFisicaVO avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}
	

	public List<AvaliacaoFisicaVO> getListaAvaliacaoFisicaVO() {
		return listaAvaliacaoFisicaVO;
	}
	
	public String cancelar(){
		return "";
	}
	
	public String incluir(){
		avaliacaoFisicaService.incluir(avaliacaoFisica);		
		return "";
	}
	
	public String excluir(){
		avaliacaoFisicaService.excluir(avaliacaoFisica);
		return "";
	}
	
	public String alterar(){
		avaliacaoFisicaService.alterar(avaliacaoFisica);
		return "";
	}
}
