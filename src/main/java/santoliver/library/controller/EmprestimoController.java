package santoliver.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import santoliver.library.dto.NovoEmprestimo;
import santoliver.library.model.Emprestimo;
import santoliver.library.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoService emprestimoService;
	
	@GetMapping
	public ResponseEntity<Iterable<Emprestimo>> buscarTodosEmprestimos(){
		return ResponseEntity.ok(emprestimoService.buscarTodosEmprestimos());
	}
	
	@GetMapping("/{emprestimoId}")
	public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Integer emprestimoId) {
		return ResponseEntity.ok(emprestimoService.buscarEmprestimoPorId(emprestimoId));
	}
	
	@PostMapping
	public ResponseEntity<NovoEmprestimo> fazerEmprestimo(@RequestBody NovoEmprestimo novoEmprestimo) {
		emprestimoService.fazerEmprestimo(novoEmprestimo);
		return ResponseEntity.ok(novoEmprestimo);
	}
	
	@PutMapping("/{emprestimoId}")
	public ResponseEntity<Emprestimo> devolverLivro(@PathVariable Integer emprestimoId, Emprestimo emprestimo) {
		emprestimoService.devolverLivro(emprestimoId, emprestimo);
		return ResponseEntity.ok(emprestimo);
	}
}
