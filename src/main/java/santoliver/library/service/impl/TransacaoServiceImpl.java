package santoliver.library.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santoliver.library.dto.NovaTransacao;
import santoliver.library.model.Estudante;
import santoliver.library.model.Livro;
import santoliver.library.model.Transacao;
import santoliver.library.repository.TransacaoRepository;
import santoliver.library.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService {
	
	@Autowired
	private TransacaoRepository transacaoRepository;

	@Override
	public Iterable<Transacao> buscarTodasTransacoes() {
		return transacaoRepository.findAll();
	}

	@Override
	public Transacao buscarTransacaoPorId(Integer transacaoId) {
		Optional<Transacao> transacao = transacaoRepository.findById(transacaoId);
		return transacao.get();
	}

	@Override
	public Transacao buscarTransacaoPorEstudante(Integer estudanteId, Integer id) {
		Transacao transacaoPorEstudante = null;
		Estudante estudanteBusca = new Estudante();
		estudanteBusca.setId(id);
		
		for(Transacao t : buscarTodasTransacoes()) {
			if(t.getEstudanteId() == estudanteBusca.getId()) {
				transacaoPorEstudante = t;
			}			
		}
		
		return transacaoPorEstudante;
	}

	@Override
	public Transacao buscarTransacaoPorLivro(Integer livroId, Integer id) {
		Transacao transacaoPorLivro = null;
		Livro livroBusca = new Livro();
		livroBusca.setId(id);
		
		for(Transacao t : buscarTodasTransacoes()) {
			if(t.getEstudanteId() == livroBusca.getId()) {
				transacaoPorLivro = t;
			}
		}
		
		return transacaoPorLivro;
	}

	@Override
	public void novaTransacao(NovaTransacao novaTransacao) {
		Transacao transacao = new Transacao();
		
		transacao.setEstudanteId(novaTransacao.getEstudanteId());
		transacao.setLivroId(novaTransacao.getLivroId());
		transacao.setDataEmprestimo(LocalDate.now());
		transacao.setDataDevolucao(LocalDate.now().plusDays(7));
		transacao.setEstaPendente(novaTransacao.getEstaPendente());
		transacao.setFatura(novaTransacao.getFatura());
		
		transacaoRepository.save(transacao);
	}

	@Override
	public void atualizarTransacao(Integer transacaoId, Transacao transacao) {
		for(Transacao t : buscarTodasTransacoes()) {
			if(t.getTransacaoId() == transacao.getTransacaoId()) {
				t.setFatura(transacao.getFatura());;
				break;
			}
		}
		
	}

	@Override
	public void deletarTransacao(Integer transacaoId) {
		transacaoRepository.deleteById(transacaoId);		
	}

}
