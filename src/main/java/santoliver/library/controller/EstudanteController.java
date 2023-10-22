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

import santoliver.library.model.Estudante;
import santoliver.library.service.EstudanteService;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

	@Autowired
	private EstudanteService estudanteService;
	
	@GetMapping
	public ResponseEntity<Iterable<Estudante>> buscarTodosEstudantes() {
		return ResponseEntity.ok(estudanteService.buscarTodosEstudantes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Integer id) {
		return ResponseEntity.ok(estudanteService.buscarEstudantePorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Estudante> inserirEstudante(@RequestBody Estudante estudante) {
		estudanteService.inserirEstudante(estudante);
		return ResponseEntity.ok(estudante);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Integer id, @RequestBody Estudante estudante) {
		estudanteService.atualizarEstudante(id, estudante);
		return ResponseEntity.ok(estudante);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarEstudante(@PathVariable Integer id) {
		estudanteService.deletarEstudante(id);
		return ResponseEntity.ok().build();
	}
}
