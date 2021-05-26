package github.com.brunomeloesilva.transacao.consumidor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;

import github.com.brunomeloesilva.transacao.dto.TransacaoRequest;
import github.com.brunomeloesilva.transacao.model.CartaoModel;
import github.com.brunomeloesilva.transacao.model.EstabelecimentoModel;
import github.com.brunomeloesilva.transacao.model.TransacaoModel;
import github.com.brunomeloesilva.transacao.repository.CartaoRepository;
import github.com.brunomeloesilva.transacao.repository.EstabelecimentoRepository;
import github.com.brunomeloesilva.transacao.repository.TransacaoRepository;

@Configuration
public class KafkaConsumidor {
	
	private CartaoRepository cartaoRepository;
	private EstabelecimentoRepository estabelecimentoRepository;
	private TransacaoRepository transacaoRepository;

	public KafkaConsumidor(CartaoRepository cartaoRepository
						 , EstabelecimentoRepository estabelecimentoRepository
						 , TransacaoRepository transacaoRepository) {
		this.cartaoRepository = cartaoRepository;
		this.estabelecimentoRepository = estabelecimentoRepository;
		this.transacaoRepository = transacaoRepository;
	}
	
	@Bean
	public JsonMessageConverter JsonMessageConverter() {
		return new JsonMessageConverter();
	}
	
	@KafkaListener(id = "registradorDeTransacao", topics = "transacoes")
	public void consumidorTransacao(TransacaoRequest transacao) {
		salvaTransacao(transacao);
	}

	private void salvaTransacao(TransacaoRequest transacao) {
		CartaoModel cartaoModel = salvaCartao(transacao);
		EstabelecimentoModel estabelecimentoModel = salvaEstabelecimento(transacao);
		TransacaoModel transacaoModel = transacao.toModel(cartaoModel, estabelecimentoModel);
		transacaoRepository.save(transacaoModel);
	}

	private CartaoModel salvaCartao(TransacaoRequest transacao) {
		CartaoModel cartaoModel = transacao.getCartaoModel();
		cartaoRepository.save(cartaoModel);
		return cartaoModel;
	}
	
	private EstabelecimentoModel salvaEstabelecimento(TransacaoRequest transacao) {
		EstabelecimentoModel estabelecimentoModel = estabelecimentoRepository.findByNomeLike(transacao.getEstabelecimento().getNome());
		if(estabelecimentoModel == null) {
			estabelecimentoModel = transacao.getEstabelecimentoModel();
			estabelecimentoRepository.save(estabelecimentoModel);
		}
		return estabelecimentoModel;
	}
}
