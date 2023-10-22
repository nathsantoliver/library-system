package santoliver.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import santoliver.library.model.BoletoFatura;
import santoliver.library.service.BoletoFaturaService;

@RestController
@RequestMapping("/boletos")
public class BoletoFaturaController {
	
	@Autowired
	private BoletoFaturaService boletoFaturaService;
	
	@GetMapping
	public ResponseEntity<Iterable<BoletoFatura>> buscarTodosBoletos() {
		return ResponseEntity.ok(boletoFaturaService.buscarTodosBoletos());
	}
	
	@DeleteMapping("/{codBoleto}")
	public ResponseEntity<Void> deletarBoleto(Long codBoleto) {
		boletoFaturaService.deletarBoleto(codBoleto);
		return ResponseEntity.ok().build();
	}

}
