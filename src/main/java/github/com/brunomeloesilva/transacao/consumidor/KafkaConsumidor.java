package github.com.brunomeloesilva.transacao.consumidor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;

import github.com.brunomeloesilva.transacao.consumidor.dto.Transacao;

@Configuration
public class KafkaConsumidor {
	
	@Bean
	public JsonMessageConverter JsonMessageConverter() {
		return new JsonMessageConverter();
	}
	
	@KafkaListener(id = "numeroCartao01", topics = "transacoes")
	public void get(Transacao transacao) {
		System.out.println(transacao.toString());
	}
    
}