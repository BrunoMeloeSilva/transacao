package github.com.brunomeloesilva.transacao.consumidor.dto;

public class Estabelecimento {

	public String nome;
	public String cidade;
	public String endereco;

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "Estabelecimento [nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	}
}