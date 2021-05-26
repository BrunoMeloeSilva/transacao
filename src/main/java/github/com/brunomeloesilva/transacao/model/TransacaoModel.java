package github.com.brunomeloesilva.transacao.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACAO")
public class TransacaoModel {

	@Id
	public String id;
	public BigDecimal valor;
	@ManyToOne
	public EstabelecimentoModel estabelecimento;
	@ManyToOne
	public CartaoModel cartao;
	public Date efetivadaEm;

	@Deprecated
	public TransacaoModel() {/*Para Hibernate*/}
	public TransacaoModel(String id, BigDecimal valor, EstabelecimentoModel estabelecimento, CartaoModel cartao,
			Date efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoModel getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoModel getCartao() {
		return cartao;
	}

	public Date getEfetivadaEm() {
		return efetivadaEm;
	}
}