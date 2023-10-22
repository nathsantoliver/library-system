package santoliver.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BoletoFatura {
	
	@Id
	private Long codBoleto;
	private Double valor;
	
	public Long getCodBoleto() {
		return codBoleto;
	}
	public void setCodBoleto(Long codBoleto) {
		this.codBoleto = codBoleto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

}
