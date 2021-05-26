package github.com.brunomeloesilva.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTABELECIMENTO")
public class EstabelecimentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cidade;
	private String endereco;

	@Deprecated
	public EstabelecimentoModel() {/*Para Hibernate*/}
	public EstabelecimentoModel(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}
}