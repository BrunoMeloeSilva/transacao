package github.com.brunomeloesilva.transacao.dto;

import java.math.BigDecimal;
import java.util.Date;

import github.com.brunomeloesilva.transacao.model.TransacaoModel;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoRequest estabelecimento;
	private Date efetivadaEm;

	public TransacaoResponse(TransacaoModel transacaoModel) {
		this.id = transacaoModel.getId();
		this.valor = transacaoModel.getValor();
		String nome = transacaoModel.getEstabelecimento().getNome();
		String cidade = transacaoModel.getEstabelecimento().getCidade();
		String endereco = transacaoModel.getEstabelecimento().getEndereco();
		this.estabelecimento = new EstabelecimentoRequest(nome, cidade, endereco);
		this.efetivadaEm = transacaoModel.getEfetivadaEm();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoRequest getEstabelecimento() {
		return estabelecimento;
	}

	public Date getEfetivadaEm() {
		return efetivadaEm;
	}
}
