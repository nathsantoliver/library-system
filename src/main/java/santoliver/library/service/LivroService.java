package santoliver.library.service;

import java.util.List;

import santoliver.library.dto.NovoLivro;
import santoliver.library.model.Livro;

public interface LivroService {
	
	public void inserirLivro(NovoLivro novoLivro);

	public Iterable<Livro> buscarTodosLivros();

	public Livro buscarLivroPorId(Integer id);

	public Livro buscarLivroPorTitulo(String titulo);

	public List<Livro> buscarLivroPorAutor(String autor);

	public void atualizarStatusLivro(Integer id, Livro livro);
	
	public void deletarLivro(Integer id);

}
