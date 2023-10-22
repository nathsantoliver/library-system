package santoliver.library.service;

import santoliver.library.dto.NovoLivro;
import santoliver.library.model.Livro;

public interface LivroService {
	
	public Iterable<Livro> buscarTodosLivros();

	public Livro buscarLivroPorId(Integer id);

//	public Livro buscarLivroPorTitulo(String titulo);

//	public List<Livro> buscarLivroPorAutor(String autor);

	public void inserirLivro(NovoLivro novoLivro);

	public void atualizarLivro(Integer id, Livro livro);
	
	public void deletarLivro(Integer id);

}
