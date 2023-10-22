package santoliver.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santoliver.library.model.BoletoFatura;
import santoliver.library.repository.BoletoFaturaRepository;
import santoliver.library.service.BoletoFaturaService;

@Service
public class BoletoFaturaServiceImpl implements BoletoFaturaService {
	
	@Autowired
	private BoletoFaturaRepository boletoFaturaRepository;

	@Override
	public Iterable<BoletoFatura> buscarTodosBoletos() {
		return boletoFaturaRepository.findAll();
	}

	@Override
	public void deletarBoleto(Long codBoleto) {
		boletoFaturaRepository.deleteById(codBoleto);
	}
	
	

}
