package github.com.brunomeloesilva.transacao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARTAO")
public class CartaoModel {

	@Id
	private String id;
	private String email;

	@Deprecated
	public CartaoModel() {/*Para Hibernate*/}
	public CartaoModel(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
}