package github.com.brunomeloesilva.transacao.consumidor.dto;

public class Transacao {

	public String id;
	public Float valor;
	public Estabelecimento estabelecimento;
	public Cartao cartao;
	public String efetivadaEm;

	public String getId() {
		return id;
	}

	public Float getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public String getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento + ", cartao="
				+ cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}
}