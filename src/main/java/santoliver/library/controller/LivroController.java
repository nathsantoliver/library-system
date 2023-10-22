package santoliver.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import santoliver.library.dto.NovoLivro;
import santoliver.library.model.Livro;
import santoliver.library.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public ResponseEntity<Iterable<Livro>> buscarTodosLivros() {
		return ResponseEntity.ok(livroService.buscarTodosLivros());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(livroService.buscarLivroPorId(id));
	}

	
	@PostMapping
	public ResponseEntity<NovoLivro> inserirLivro(@RequestBody NovoLivro novoLivro) {
		livroService.inserirLivro(novoLivro);
		return ResponseEntity.ok(novoLivro);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizarLivro(@PathVariable Integer id, @RequestBody Livro livro) {
		livroService.atualizarLivro(id, livro);
		return ResponseEntity.ok(livro);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarLivro(@PathVariable Integer id) {
		livroService.deletarLivro(id);
		return ResponseEntity.ok().build();
	}
		
}
