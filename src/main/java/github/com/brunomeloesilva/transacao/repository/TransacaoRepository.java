package github.com.brunomeloesilva.transacao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import github.com.brunomeloesilva.transacao.model.TransacaoModel;


public interface TransacaoRepository extends JpaRepository<TransacaoModel, String> {
	
	@Query("FROM TransacaoModel t JOIN FETCH t.cartao c JOIN FETCH t.estabelecimento e WHERE c.id = :idCartao")
	List<TransacaoModel> findByCartaoId(String idCartao, Pageable pageable);
}
