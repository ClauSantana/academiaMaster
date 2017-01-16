package br.com.academia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.academia.exception.BusinessException;
import br.com.academia.service.CategoriaService;
import br.com.academia.service.ProdutoService;
import br.com.academia.vo.CategoriaVO;
import br.com.academia.vo.ProdutoVO;

@ManagedBean(name = "produtoMbean")
@SessionScoped
public class ProdutoController extends AbstractController{

	public static String TELA_CADASTRAR_PRODUTO = "/produto/cadastrar_produto.xhtml";
	public static String TELA_LISTAR_TODOS = "/produto/listar_todos_produtos.xhtml";
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	private List<ProdutoVO> listaExclusao = new ArrayList<ProdutoVO>();
	private List<CategoriaVO> listaCategoriaVO;
	private List<ProdutoVO> listaProdutoVO;
	private ProdutoVO produto = new ProdutoVO();
	private CategoriaVO categoriaVO = new CategoriaVO();
	
	@PostConstruct
	public void init(){
		super.getConfigSpring();
		this.listaCategoriaVO = categoriaService.listarTodasCategorias();
	}

	public ProdutoVO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVO produto) {
		this.produto = produto;
	}
	
	/**
	 * 
	 * @return
	 */
	public String salvar() {
		// Calling Business Service
		produto.setCategoriaVO(this.getCategoriaVO());
		
		try {
			if(produto.getId() == 0){
				produtoService.salvarProduto(produto);				
			}else{
				produtoService.alterarProduto(produto);
			}
			// Add message
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Produto gravado com sucesso!"));
		} catch (BusinessException e) {
			// Add message
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,null,e.getMessage()));
		}
		return "";
	}
	
	public String excluir(ProdutoVO produto){
		if(produto != null && produto.getId() != 0){
			this.produtoService.excluirProduto(produto.getId());			
		}
		
		this.listaProdutoVO = produtoService.listarTodosProdutos();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Produto Excluido com sucesso!"));
		return "";
	}
	
	public String chamarTelaAlterar(){
		
		
		
		return TELA_CADASTRAR_PRODUTO;
	}
	
	private void limparCampos(){
		this.getProduto().setDescricao(null);
		this.getProduto().setValor(null);
	}
	
	public String chamarTelaCadastro(){
		this.listaCategoriaVO = categoriaService.listarTodasCategorias();
		return TELA_CADASTRAR_PRODUTO;
	}
	
	public String chamarTelaListarTodos(){
		this.listaProdutoVO = produtoService.listarTodosProdutos();
		return TELA_LISTAR_TODOS;
	}

	public List<CategoriaVO> getListaCategoriaVO() {
		return listaCategoriaVO;
	}

	public void setListaCategoriaVO(List<CategoriaVO> listaCategoriaVO) {
		this.listaCategoriaVO = listaCategoriaVO;
	}

	public void setListaProdutoVO(List<ProdutoVO> listaProdutoVO) {
		this.listaProdutoVO = listaProdutoVO;
	}

	public List<ProdutoVO> getListaProdutoVO() {
		return listaProdutoVO;
	}

	public CategoriaVO getCategoriaVO() {
		return categoriaVO;
	}

	public void setCategoriaVO(CategoriaVO categoriaVO) {
		this.categoriaVO = categoriaVO;
	}
	
}
