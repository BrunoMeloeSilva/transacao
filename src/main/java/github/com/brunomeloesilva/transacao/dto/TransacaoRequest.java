package github.com.brunomeloesilva.transacao.dto;

import java.math.BigDecimal;
import java.util.Date;

import github.com.brunomeloesilva.transacao.model.CartaoModel;
import github.com.brunomeloesilva.transacao.model.EstabelecimentoModel;
import github.com.brunomeloesilva.transacao.model.TransacaoModel;

public class TransacaoRequest {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoRequest estabelecimento;
	private CartaoRequest cartao;
	private Date efetivadaEm;

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoRequest getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoRequest getCartao() {
		return cartao;
	}

	public Date getEfetivadaEm() {
		return efetivadaEm;
	}

	public CartaoModel getCartaoModel() {
		return new CartaoModel(getCartao().getId()
							 , getCartao().getEmail());
	}

	public EstabelecimentoModel getEstabelecimentoModel() {
		return new EstabelecimentoModel(getEstabelecimento().getNome()
									  , getEstabelecimento().getCidade()
									  , getEstabelecimento().getEndereco());
	}

	public TransacaoModel toModel(CartaoModel cartao, EstabelecimentoModel estabelecimento) {
		return new TransacaoModel(this.id
								, this.valor
								, estabelecimento
								, cartao
								, this.efetivadaEm);
	}
}
