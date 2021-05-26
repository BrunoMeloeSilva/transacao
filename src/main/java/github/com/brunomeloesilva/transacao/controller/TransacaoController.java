package github.com.brunomeloesilva.transacao.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import github.com.brunomeloesilva.transacao.dto.TransacaoResponse;
import github.com.brunomeloesilva.transacao.model.TransacaoModel;
import github.com.brunomeloesilva.transacao.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	private TransacaoRepository transacaoRepository;

	public TransacaoController(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	@GetMapping("ultimas-transacoes/10/{idCartao}")
	public ResponseEntity<List<TransacaoResponse>> ultimasTransacoes(@PathVariable String idCartao) {
		PageRequest page = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "efetivadaEm"));
		List<TransacaoModel> transacoesModel = transacaoRepository.findByCartaoId(idCartao, page);
		
		if(transacoesModel.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O cartão informado não existe.");
		}
		
		List<TransacaoResponse> transacoesResponse = transacoesModel.stream().map(TransacaoResponse::new).collect(Collectors.toList());
		return ResponseEntity.ok(transacoesResponse);
	}
}
