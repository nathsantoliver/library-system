package santoliver.library.service;

import santoliver.library.dto.NovoEstudante;
import santoliver.library.model.Estudante;

public interface EstudanteService {

	Iterable<Estudante> buscarTodosEstudantes();
	
	Estudante buscarEstudantePorId(Integer id);
	
	void inserirEstudante(NovoEstudante novoEstudante);
	
	void atualizarEstudante(Integer id, Estudante estudante);
	
	void deletarEstudante(Integer id);
	
}
