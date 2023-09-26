package santoliver.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santoliver.library.dto.NovaFatura;
import santoliver.library.model.Fatura;
import santoliver.library.model.Livro;
import santoliver.library.repository.FaturaRepository;
import santoliver.library.repository.LivroRepository;
import santoliver.library.service.FaturaService;

@Service
public class FaturaServiceImpl implements FaturaService {
	
	@Autowired
	private FaturaRepository faturaRepository;

	@Override
	public void gerarFatura(NovaFatura novaFatura) {
		Fatura fatura = new Fatura();
		
		Double valor = novaFatura.getValor();
		valor = 7.59;
		
		fatura.setValor(valor);
		
		faturaRepository.save(fatura);
	}
	
	@Override
	public Iterable<Fatura> buscarFaturas() {
		return faturaRepository.findAll();
	}

	@Override
	public Fatura buscarFaturaPorId(Integer idFatura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizarFatura(Integer idFatura, Fatura fatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarFatura(Integer idFatura) {
		// TODO Auto-generated method stub
		
	}

}
