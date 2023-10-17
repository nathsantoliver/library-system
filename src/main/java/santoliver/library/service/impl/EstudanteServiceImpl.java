package santoliver.library.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santoliver.library.dto.NovoEstudante;
import santoliver.library.model.Endereco;
import santoliver.library.model.Estudante;
import santoliver.library.repository.EnderecoRepository;
import santoliver.library.repository.EstudanteRepository;
import santoliver.library.service.EstudanteService;
import santoliver.library.service.ViaCepService;

@Service
public class EstudanteServiceImpl implements EstudanteService {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Estudante> buscarTodosEstudantes() {
		return estudanteRepository.findAll();
	}

	@Override
	public Estudante buscarEstudantePorId(Integer id) {
		Optional<Estudante> estudante = estudanteRepository.findById(id);
		return estudante.get();
	}

	@Override
	public void inserirEstudante(NovoEstudante estudante) {
		salvarEstudanteComCep(estudante);
	}

	@Override
	public void atualizarEstudante(Integer id, Estudante estudante) {
//		Optional<Estudante> estudanteBd = estudanteRepository.findById(id);
//		if(estudanteBd.isPresent()) {
//			salvarEstudanteComCep(estudante);
//		}
		for(Estudante e : buscarTodosEstudantes()) {
			if(e.getId() == estudante.getId()) {
				e.setNome(estudante.getNome());
				e.setTelefone(estudante.getTelefone());
				
				String cep = estudante.getEndereco().getCep();
				Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
					Endereco novoEndereco = viaCepService.consultarCep(cep);
					enderecoRepository.save(novoEndereco);
					return novoEndereco;
				});
				
				e.setEndereco(endereco);
			}
		}
	}

	@Override
	public void deletarEstudante(Integer id) {
		estudanteRepository.deleteById(id);
	}
	
	private void salvarEstudanteComCep(NovoEstudante novoEstudante) {
		Estudante estudante = new Estudante();
		
		estudante.setNome(novoEstudante.getNome());
		estudante.setTelefone(novoEstudante.getTelefone());
		
		String cep = estudante.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		estudante.setEndereco(endereco);
		
		estudanteRepository.save(estudante);
	}

}
