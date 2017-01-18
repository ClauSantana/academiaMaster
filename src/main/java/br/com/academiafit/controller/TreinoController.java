package br.com.academiafit.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.academiafit.service.TreinoService;
import br.com.academiafit.vo.TreinoVO;

@Controller("treinoMbean")
@Scope("session")
public class TreinoController {
	
	private TreinoService treinoService;
	private List<TreinoVO> listaTreinoVO;
	private TreinoVO treino = new TreinoVO();
	
	@Autowired
	public TreinoController(TreinoService treinoService){
		this.treinoService = treinoService;
	}
	
	@PostConstruct
	public void init(){
		//System.out.println(listaTreinoVO);
	}

	public TreinoVO getTreino() {
		return treino;
	}

	public void setTreino(TreinoVO treino) {
		this.treino = treino;
	}
	

	public List<TreinoVO> getListaTreinoVO() {
		return listaTreinoVO;
	}
	
	public String cancelar(){
		return "";
	}
	
	public String incluir(){
		treinoService.incluir(treino);		
		return "";
	}
	
	public String excluir(){
		treinoService.excluir(treino);
		return "";
	}
	
	public String alterar(){
		treinoService.alterar(treino);
		return "";
	}

}
