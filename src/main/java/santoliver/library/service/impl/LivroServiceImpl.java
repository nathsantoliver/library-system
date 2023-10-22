package santoliver.library.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santoliver.library.dto.NovoLivro;
import santoliver.library.model.Livro;
import santoliver.library.repository.LivroRepository;
import santoliver.library.service.LivroService;

@Service
public class LivroServiceImpl implements LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public Iterable<Livro> buscarTodosLivros() {
		return livroRepository.findAll();
	}
	
	@Override
	public Livro buscarLivroPorId(Integer id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.get();
	}
	
//	@Override
//	public Livro buscarLivroPorTitulo(String titulo) {
//		Livro livroPorTitulo = null;
//		
//		for(Livro l : buscarTodosLivros()) {
//			if(l.getTitulo().equalsIgnoreCase(titulo)) {
//				livroPorTitulo = l;
//				break;
//			}
//		}
//		
//		return livroPorTitulo;
//	}

//	@Override
//	public List<Livro> buscarLivroPorAutor(String autor) {
//		List<Livro> livrosPorAutor = new ArrayList<>();
//		for(Livro l : buscarTodosLivros()) {
//			if(l.getAutor().equalsIgnoreCase(autor)) {
//				livrosPorAutor.add(l);
//			}
//		}
//		return livrosPorAutor;
//	}

	@Override
	public void inserirLivro(NovoLivro novoLivro) {
		Livro livro = new Livro();
		
		livro.setTitulo(novoLivro.getTitulo());
		livro.setAutor(novoLivro.getAutor());
		livro.setEdicao(novoLivro.getEdicao());
		livro.setStatus(novoLivro.getStatus());
		
		livroRepository.save(livro);
	}

	@Override
	public void atualizarLivro(Integer id, Livro livro) {
		for(Livro l : buscarTodosLivros()) {
			if(l.getId() == livro.getId()) {
				l.setTitulo(livro.getTitulo());
				l.setAutor(livro.getAutor());
				l.setEdicao(livro.getEdicao());
				l.setStatus(livro.getStatus());
				
				livroRepository.save(l);
				break;
			}
		}
	}

	@Override
	public void deletarLivro(Integer id) {
		livroRepository.deleteById(id);
	}

}
