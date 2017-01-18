package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.Funcionario;
import br.com.academiafit.vo.FuncionarioVO;

public class ConverterFuncionario {

	public static Funcionario ConverterFuncionarioVoParaFuncionario(FuncionarioVO funcionarioVO){
		Funcionario funcionario = new Funcionario();
		
		funcionario.setDatacontrato(funcionarioVO.getDatacontrato());
		funcionario.setEscolaridade(funcionarioVO.getEscolaridade());
		
		return funcionario;
	
	}
	
	
	public static FuncionarioVO ConverterFuncionarioParaVO(Funcionario funcionario){
		FuncionarioVO funcionarioVO = new FuncionarioVO();
	
		funcionario.setDatacontrato(funcionarioVO.getDatacontrato());
		funcionario.setEscolaridade(funcionarioVO.getEscolaridade());
		
		
		return funcionarioVO;
	
}
     public static List<FuncionarioVO> ConverterFuncionarioListaParaVo(List<Funcionario> listaEntidade){
		
		List<FuncionarioVO> listFuncionarioVO = new ArrayList<FuncionarioVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Funcionario funcionario : listaEntidade){
				FuncionarioVO funcionarioVO = ConverterFuncionarioParaVO(funcionario);
				listFuncionarioVO.add(funcionarioVO);
			}
		}
		return listFuncionarioVO;
		
	}
	
}