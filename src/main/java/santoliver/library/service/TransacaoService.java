package santoliver.library.service;

import santoliver.library.dto.NovaTransacao;
import santoliver.library.model.Transacao;

public interface TransacaoService {
	
	Iterable<Transacao> buscarTodasTransacoes();
	
	Transacao buscarTransacaoPorId(Integer transacaoId);
	
	public Transacao buscarTransacaoPorEstudante(Integer estudanteId, Integer id);

	public Transacao buscarTransacaoPorLivro(Integer livroId, Integer id);
	
	void novaTransacao(NovaTransacao novaTransacao);
	
	void deletarTransacao(Integer transacaoId);
	
}
