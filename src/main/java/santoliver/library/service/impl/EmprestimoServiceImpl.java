package santoliver.library.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santoliver.library.dto.NovoEmprestimo;
import santoliver.library.model.BoletoFatura;
import santoliver.library.model.Emprestimo;
import santoliver.library.model.Fatura;
import santoliver.library.repository.BoletoFaturaRepository;
import santoliver.library.repository.EmprestimoRepository;
import santoliver.library.service.EmprestimoService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Autowired
	private BoletoFaturaRepository boletoFaturaRepository;

	@Override
	public Iterable<Emprestimo> buscarTodosEmprestimos() {
		atualizarEmprestimo();
		return emprestimoRepository.findAll();
	}

	@Override
	public Emprestimo buscarEmprestimoPorId(Integer emprestimoId) {
		atualizarEmprestimo();
		Optional<Emprestimo> emprestimo = emprestimoRepository.findById(emprestimoId);
		return emprestimo.get();
	}

	@Override
	public void fazerEmprestimo(NovoEmprestimo novoEmprestimo) {
		Emprestimo emprestimo = new Emprestimo();
		
		emprestimo.setEstudanteId(novoEmprestimo.getEstudanteId());
		emprestimo.setLivroId(novoEmprestimo.getLivroId());
		emprestimo.setDataEmprestimo(LocalDate.now());
		emprestimo.setDevolucaoPrevista(LocalDate.now().plusDays(7));
		emprestimo.setEstaPendente(false);
		
		Fatura fatura = new Fatura();
		fatura.setValor(7.59);
		fatura.setCodFatura(new Date().getTime());
		
		emprestimo.setFatura(fatura);
		
		emprestimoRepository.save(emprestimo);
	}

	@Override
	public void devolverLivro(Integer emprestimoId, Emprestimo emprestimo) {
		for(Emprestimo emp : buscarTodosEmprestimos()) {
			if(emp.getEmprestimoId() == emprestimo.getEmprestimoId()) {
				BoletoFatura boletoFatura = new BoletoFatura();

				emprestimo.setEstudanteId(emp.getEstudanteId());
				emprestimo.setLivroId(emp.getLivroId());
				emprestimo.setDataEmprestimo(emp.getDataEmprestimo());
				emprestimo.setDevolucaoPrevista(emp.getDevolucaoPrevista());
				emprestimo.setDataDevolucao(LocalDate.now());
				emprestimo.setEstaPendente(false);
				emprestimo.setFatura(emp.getFatura());
				
				boletoFatura.setCodBoleto(emp.getFatura().getCodFatura());
				boletoFatura.setValor(emp.getFatura().getValor());
				
				boletoFaturaRepository.save(boletoFatura);
				
				emprestimoRepository.save(emprestimo);	
			}
		}
		
	}

	private void atualizarEmprestimo() {
		LocalDate hoje = LocalDate.now();
		for(Emprestimo emp : emprestimoRepository.findAll()) {
			int diasEmprestado = (int) emp.getDataEmprestimo().until(hoje, ChronoUnit.DAYS);
			if(diasEmprestado > 7 && emp.getDataDevolucao() == null) {
				emp.setEstaPendente(true);
				int i = diasEmprestado - 7;
				Double valor = emp.getFatura().getValor() + (emp.getFatura().getValor() * (i * 0.15));
				emp.getFatura().setValor(valor);
				emprestimoRepository.save(emp);
				break;
			} else if(emp.getDataDevolucao() != null) {
				emp.setEstaPendente(false);
			}
		}
	}

}
