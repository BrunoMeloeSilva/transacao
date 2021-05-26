package github.com.brunomeloesilva.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.transacao.model.CartaoModel;

public interface CartaoRepository extends JpaRepository<CartaoModel, String> {}
