package santoliver.library.service;

import santoliver.library.dto.NovoEmprestimo;
import santoliver.library.model.Emprestimo;

public interface EmprestimoService {
	
	Iterable<Emprestimo> buscarTodosEmprestimos();
	
	Emprestimo buscarEmprestimoPorId(Integer emprestimoId);
	
	void fazerEmprestimo(NovoEmprestimo novoEmprestimo);
	
	void devolverLivro(Integer emprestimoId, Emprestimo emprestimo);
	
}
