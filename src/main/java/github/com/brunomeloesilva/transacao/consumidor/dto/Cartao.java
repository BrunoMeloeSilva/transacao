package github.com.brunomeloesilva.transacao.consumidor.dto;

public class Cartao {

	public String id;
	public String email;

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", email=" + email + "]";
	}
}