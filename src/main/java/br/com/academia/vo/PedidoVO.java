package br.com.academia.vo;

import java.util.Date;
import java.util.List;

public class PedidoVO {
	
	private long id;
	private ClienteVO cliente;
	private List<ItemPedidoVO> listaItemPedidoVO;
	private Date dataPedido;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedidoVO> getListaItemPedidoVO() {
		return listaItemPedidoVO;
	}
	public void setListaItemPedidoVO(List<ItemPedidoVO> listaItemPedidoVO) {
		this.listaItemPedidoVO = listaItemPedidoVO;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	

}
