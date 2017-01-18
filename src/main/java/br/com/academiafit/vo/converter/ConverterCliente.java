package br.com.academiafit.vo.converter;


import java.util.ArrayList;
import java.util.List;
import br.com.academiafit.entidade.Cliente;
import br.com.academiafit.vo.ClienteVO;

public class ConverterCliente {
	public static Cliente ConverterClienteVoParaCliente(ClienteVO clienteVO){
		Cliente cliente = new Cliente();
		
		cliente.setPeso(clienteVO.getPeso());
		cliente.setAltura(clienteVO.getAltura());
		cliente.setDatacadastro(clienteVO.getDatacadastro());
		cliente.setDesenvolvimento(clienteVO.getDesenvolvimento());
		
		return cliente;
		
		
	}
	
	
	public static ClienteVO ConverterClienteParaVO(Cliente cliente){
		ClienteVO clienteVO = new ClienteVO();
	
		clienteVO.setPeso(cliente.getPeso());
		clienteVO.setAltura(cliente.getAltura());
		clienteVO.setDatacadastro(cliente.getDatacadastro());
		clienteVO.setDesenvolvimento(cliente.getDesenvolvimento());
		
		return clienteVO;
	
}
     public static List<ClienteVO> ConverterClienteParaListaVo(List<Cliente> listaEntidade){
		
		List<ClienteVO> listClienteVO = new ArrayList<ClienteVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Cliente cliente : listaEntidade){
				ClienteVO clienteVO = ConverterClienteParaVO(cliente);
				listClienteVO.add(clienteVO);
			}
		}
		return listClienteVO;
		
	}
	
}