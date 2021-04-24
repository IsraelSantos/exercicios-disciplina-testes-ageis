package br.uece.me.model;

import java.math.BigDecimal;
import java.util.UUID;

import br.uece.me.model.enumeration.Zona;
import lombok.Data;

@Data
public class Pagamento {
	
	private UUID id;

	private BigDecimal valor;
	
	private Zona abrangencia;
	
	private Usuario usuario;
	
	public Pagamento() {
		this.id = UUID.randomUUID();
	}
}
