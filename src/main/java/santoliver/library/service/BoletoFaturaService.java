package santoliver.library.service;

import santoliver.library.model.BoletoFatura;

public interface BoletoFaturaService {
	
	Iterable<BoletoFatura> buscarTodosBoletos();
	
	void deletarBoleto(Long codBoleto);

}
