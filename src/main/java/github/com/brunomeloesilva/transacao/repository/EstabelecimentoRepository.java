package github.com.brunomeloesilva.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.transacao.model.EstabelecimentoModel;

public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoModel, Long> {
	//TODO Deveria ser pelo CNPJ, mas num tem, vai nome mesmo :)
	EstabelecimentoModel findByNomeLike(String nome);
}
