package santoliver.library.service;

import santoliver.library.dto.NovaFatura;
import santoliver.library.model.Fatura;

public interface FaturaService {
	
	void gerarFatura(NovaFatura novaFatura);
	
	Iterable<Fatura> buscarFaturas();
	
	Fatura buscarFaturaPorId(Integer idFatura);
	
	void atualizarFatura(Integer idFatura, Fatura fatura);
	
	void deletarFatura(Integer idFatura);

}
