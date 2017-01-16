package br.com.academia.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academia.entidade.Categoria;
import br.com.academia.entidade.Cliente;
import br.com.academia.entidade.ItemPedido;
import br.com.academia.entidade.Pedido;
import br.com.academia.entidade.Produto;
import br.com.academia.vo.CategoriaVO;
import br.com.academia.vo.ClienteVO;
import br.com.academia.vo.ItemPedidoVO;
import br.com.academia.vo.PedidoVO;
import br.com.academia.vo.ProdutoVO;

/**
 * Classe responsável por converter uma entidade (Entity) em um VO ou vice e versa
 * @author MARCOS
 *
 */

public class Converter {

	/**
	 * Converter uma classe VO para uma entidade Cliente
	 * VO --> Cliente
	 * @param clienteVO
	 * @return
	 */
	public static Cliente converterVoParaCliente(ClienteVO clienteVO){
		Cliente cliente = new Cliente();
		
		cliente.setNome(clienteVO.getNome());
		cliente.setDataNascimento(clienteVO.getDataNascimento());
		cliente.setEmail(clienteVO.getEmail());
		cliente.setCpf(clienteVO.getCpf());
		return cliente;
	}
	
	/**
	 * Converter uma entidade em uma classe vo cliente
	 * Cliente --> VO
	 * @param cliente
	 * @return
	 */
	public static ClienteVO converterClienteParaVO(Cliente cliente){
		ClienteVO clienteVo = new ClienteVO();
		clienteVo.setId(cliente.getId());
		clienteVo.setNome(cliente.getNome());
		clienteVo.setDataNascimento(cliente.getDataNascimento());
		clienteVo.setEmail(cliente.getEmail());
		clienteVo.setCpf(cliente.getCpf());
		return clienteVo;
	}
	
	/**
	 * Converter uma lista de entidade cliente em uma lista de entidade vo
	 * 
	 * @param listaEntidade
	 * @return
	 */
	public static List<ClienteVO> converterListaClienteParaListaVo(List<Cliente> listaEntidade){
		
		List<ClienteVO> listClienteVO = new ArrayList<ClienteVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Cliente cliente : listaEntidade){
				ClienteVO clienteVO = converterClienteParaVO(cliente);
				listClienteVO.add(clienteVO);
			}
		}
		return listClienteVO;
	}
	
	/**
	 * Converter um classe vo em uma entidade Produto
	 * @param produtoVO
	 * @return
	 */
	public static Produto converterVoParaProduto(ProdutoVO produtoVO){
		Produto produto = new Produto();
		Categoria categoria = converterVoParaCategoria(produtoVO.getCategoriaVO());
		
		produto.setId(produtoVO.getId());
		produto.setDescricao(produtoVO.getDescricao());
		produto.setValorUnitario(produtoVO.getValor());
		produto.setCategoria(categoria);
		return produto;
	}
	
	/**
	 * Converter uma entidade Produto em uma classe VO
	 * @param produto
	 * @return
	 */
	public static ProdutoVO converterProdutoParaVO(Produto produto){
		ProdutoVO produtoVO = new ProdutoVO();
		CategoriaVO categoriaVO = converterCategoriaParaVO(produto.getCategoria());
		
		produtoVO.setId(produto.getId());
		produtoVO.setDescricao(produto.getDescricao());
		produtoVO.setValor(produto.getValorUnitario());
		produtoVO.setCategoriaVO(categoriaVO);
		return produtoVO;
	}
	
	/**
	 * Converter uma lista de entidade Produto em uma lista de Produto vo
	 * @param listaEntidade
	 * @return
	 */
	public static List<ProdutoVO> converterListaProdutoParaListaVo(List<Produto> listaEntidade){
		
		List<ProdutoVO> listProdutoVO = new ArrayList<ProdutoVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Produto produto : listaEntidade){
				ProdutoVO produtoVO = converterProdutoParaVO(produto);
				listProdutoVO.add(produtoVO);
			}
		}
		return listProdutoVO;
	}
	
	/**
	 * Converter um classe vo em uma entidade categoria
	 * @param vo
	 * @return
	 */
	public static Categoria converterVoParaCategoria(CategoriaVO vo){
		Categoria entidade = new Categoria();
		entidade.setId(vo.getId());
		entidade.setDescricao(vo.getDescricao());
		return entidade;
	}
	
	/**
	 * Converter uma entidade categoria em uma classe vo
	 * @param entidade
	 * @return
	 */
	public static CategoriaVO converterCategoriaParaVO(Categoria entidade){
		CategoriaVO vo = new CategoriaVO();
		vo.setId(entidade.getId());
		vo.setDescricao(entidade.getDescricao());
		return vo;
	}
	
	/**
	 * Converter uma lista de entidade categoria em uma lista de categoria vo
	 * @param listaEntidade
	 * @return
	 */
	public static List<CategoriaVO> converterListaCategoriaParaListaVo(List<Categoria> listaEntidade){
		
		List<CategoriaVO> listCategoriaVO = new ArrayList<CategoriaVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Categoria categoria : listaEntidade){
				CategoriaVO categoriaVO = converterCategoriaParaVO(categoria);
				listCategoriaVO.add(categoriaVO);
			}
		}
		return listCategoriaVO;
	}
	
	
	public static List<ItemPedido> converterListaItemPedidoVoParaItemPedido(List<ItemPedidoVO> listaItemPedidoVO){
		List<ItemPedido> listItemPedido = new ArrayList<>();
		if(listaItemPedidoVO != null && listaItemPedidoVO.isEmpty()){
			for(ItemPedidoVO itemPedidoVO : listaItemPedidoVO){
				ItemPedido itemPedido = new ItemPedido();
				itemPedido.setId(itemPedidoVO.getId());
				itemPedido.setQtde(itemPedidoVO.getQtde());
				itemPedido.setProduto(Converter.converterVoParaProduto(itemPedidoVO.getProduto()));
				listItemPedido.add(itemPedido);
			}
		}
		return listItemPedido;
	}
	
	
	
	public static List<ItemPedidoVO> converterListaItemPedidoParaItemPedidoVO(List<ItemPedido> listaItemPedido){
		List<ItemPedidoVO> listItemPedidoVO = new ArrayList<>();
		if(listaItemPedido != null && listaItemPedido.isEmpty()){
			for(ItemPedido itemPedido : listaItemPedido){
				ItemPedidoVO itemPedidoVO = new ItemPedidoVO();
				itemPedidoVO.setId(itemPedido.getId());
				itemPedidoVO.setQtde(itemPedido.getQtde());
				itemPedidoVO.setProduto(Converter.converterProdutoParaVO(itemPedido.getProduto()));
				listItemPedidoVO.add(itemPedidoVO);
			}
		}
		return listItemPedidoVO;
	}
	
	/**
	 * Converter VO para uma Entidade Pedido
	 * @param pedidoVO
	 * @return
	 */
	public static Pedido converterVOParaPedido(PedidoVO pedidoVO){
		Pedido pedido = new Pedido();
		Cliente cliente = Converter.converterVoParaCliente(pedidoVO.getCliente());
		
		pedido.setDataPedido(pedidoVO.getDataPedido());
		pedido.setId(pedidoVO.getId());
		pedido.setCliente(cliente);
		pedido.setListaItemProduto(converterListaItemPedidoVoParaItemPedido(pedidoVO.getListaItemPedidoVO()));
		return pedido;
	}
	
	/**
	 * Converter Entidade Pedido para VO
	 * @param pedidoVO
	 * @return
	 */
	public static PedidoVO converterPedidoParaVO(Pedido pedido){
		PedidoVO pedidoVO = new PedidoVO();
		ClienteVO clienteVO = Converter.converterClienteParaVO(pedido.getCliente());
		
		pedidoVO.setDataPedido(pedido.getDataPedido());
		pedidoVO.setId(pedido.getId());
		pedidoVO.setCliente(clienteVO);
		pedidoVO.setListaItemPedidoVO(converterListaItemPedidoParaItemPedidoVO(pedido.getListaItemProduto()));
		return pedidoVO;
	}
	
	public static List<PedidoVO> converterListaPedidoParaListaPedidoVO(List<Pedido> listaPedido){
		List<PedidoVO> listaPedidoVO = new ArrayList<>();
		if(listaPedido != null && !listaPedido.isEmpty()){
			for(Pedido pedido : listaPedido){
				PedidoVO pedidoVO = Converter.converterPedidoParaVO(pedido);
				listaPedidoVO.add(pedidoVO);
			}
		}
		return listaPedidoVO;
	}
	
}
