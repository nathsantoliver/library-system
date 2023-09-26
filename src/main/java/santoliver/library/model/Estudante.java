package santoliver.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Estudante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String telefone;
	private Boolean pendencia;
	@ManyToOne
	private Endereco endereco;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Boolean getPendencia() {
		return pendencia;
	}
	
	public void setPendencia(Boolean pendencia) {
		this.pendencia = pendencia;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	// METODOS
	// TODO: método de adicionar pendencia - adicionarPendencia()
	// TODO: método de remover pendencia - removerPendencia()
	// TODO: método de pagamento da conta - pagamentoFatura() 

}
