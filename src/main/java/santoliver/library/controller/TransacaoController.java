package santoliver.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import santoliver.library.dto.NovaTransacao;
import santoliver.library.model.Transacao;
import santoliver.library.service.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoService;
	
	@GetMapping
	public ResponseEntity<Iterable<Transacao>> buscarTodasTransacoes(){
		return ResponseEntity.ok(transacaoService.buscarTodasTransacoes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transacao> buscarTransacaoPorId(@PathVariable Integer transacaoId) {
		return ResponseEntity.ok(transacaoService.buscarTransacaoPorId(transacaoId));
	}
	
	@GetMapping("/{estudante}")
	public ResponseEntity<Transacao> buscarTransacaoPorEstudante(@PathVariable Integer estudanteId, Integer id) {
		return ResponseEntity.ok(transacaoService.buscarTransacaoPorEstudante(estudanteId, id));
	}
	
	@GetMapping("/{livro}")
	public ResponseEntity<Transacao> buscarTransacaoPorLivro(@PathVariable Integer livroId, Integer id) {
		return ResponseEntity.ok(transacaoService.buscarTransacaoPorLivro(livroId, id));
	}
	
	@PostMapping
	public ResponseEntity<NovaTransacao> novaTransacao(@RequestBody NovaTransacao novaTransacao) {
		transacaoService.novaTransacao(novaTransacao);
		return ResponseEntity.ok(novaTransacao);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletarTransacao(@PathVariable Integer transacaoId) {
		transacaoService.deletarTransacao(transacaoId);
		return ResponseEntity.ok().build();
	}
}
