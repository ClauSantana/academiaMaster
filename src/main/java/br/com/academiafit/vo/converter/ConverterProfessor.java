package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.Professor;
import br.com.academiafit.vo.ProfessorVO;

public class ConverterProfessor {
	public static Professor ConverterProfessorVoParaProfessor(ProfessorVO professorVO){
		Professor professor = new Professor();
		
		professor.setHorario(professorVO.getHorario());
		
		return professor;
		
		
	}
	
	
	public static ProfessorVO ConverterProfessorParaVO(Professor professor){
		ProfessorVO professorVO = new ProfessorVO();
	
		professor.setHorario(professorVO.getHorario());
		
		return professorVO;
	
}
     public static List<ProfessorVO> ConverterProfessorListaParaVo(List<Professor> listaEntidade){
		
		List<ProfessorVO> listProfessorVO = new ArrayList<ProfessorVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Professor professor : listaEntidade){
				ProfessorVO professorVO = ConverterProfessorParaVO(professor);
				listProfessorVO.add(professorVO);
			}
		}
		return listProfessorVO;
		
	}
	
}