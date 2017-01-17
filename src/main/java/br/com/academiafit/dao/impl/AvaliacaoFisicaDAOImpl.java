package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import br.com.academiafit.dao.AvaliacaoFisicaDAO;
import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.entidade.Usuario;

public class AvaliacaoFisicaDAOImpl extends AbstractDAOImpl implements AvaliacaoFisicaDAO{

	@Override
	public String incluir(AvaliacaoFisica avaliacaofisica) {
		// armazena a avaliação física no banco de dados
		super.getEntityManager().persist(avaliacaofisica);

		// alerta para o usuário
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Avaliação Física inserida com sucesso!"));
		return "";
	}

	@Override
	public String alterar(AvaliacaoFisica avaliacaofisica) {
		// cria uma query de atualização para a senha do usuário
		Query query = super.getEntityManager().createQuery("update AvaliacaoFisica af set af.dataavaliacao = :dataavaliacao, af.altura = :altura, af.peso = :peso, af.imc = :imc, af.peito = :peito, af.cintura = :cintura, af.quadril = :quadril, af.braco = :braco, af.coxa = :coxa, af.panturrilha = :panturrilha where af.id = :id", Usuario.class);

		// determina os parâmetros da query
		query.setParameter("dataavaliacao", avaliacaofisica.getDataavaliacao());
		query.setParameter("altura", avaliacaofisica.getAltura());
		query.setParameter("peso", avaliacaofisica.getPeso());
		query.setParameter("imc", avaliacaofisica.getImc()); 
		query.setParameter("peito", avaliacaofisica.getPeito()); 
		query.setParameter("cintura", avaliacaofisica.getCintura()); 
		query.setParameter("quadril", avaliacaofisica.getQuadril()); 
		query.setParameter("braco", avaliacaofisica.getBraco()); 
		query.setParameter("coxa", avaliacaofisica.getCoxa()); 
		query.setParameter("panturrilha", avaliacaofisica.getPanturrilha());

		// executa a query
		query.executeUpdate();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados alterados com sucesso"));	

		return "";
	}

	@Override
	public String excluir(int index) {
		// verifica se o nickname fornecido existe no banco de dados
		AvaliacaoFisica avaliacao = super.getEntityManager().find(AvaliacaoFisica.class,index);

		// exclui o usuario correspondente
		super.getEntityManager().remove(avaliacao);
		
		return "";
	}

	@Override
	public List<AvaliacaoFisica> consultarTodos() {		
		// cria uma query com o select na tabela
		Query query = super.getEntityManager().createQuery("select af from AvaliacaoFisica af");

		// armazena o resultado da busca numa collection
		List<AvaliacaoFisica> listaAvaliacao = query.getResultList();

		// fecha a conexão
		super.getEntityManager().close();

		return listaAvaliacao;
	}
}
