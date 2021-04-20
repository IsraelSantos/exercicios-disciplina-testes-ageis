package br.uece.me.model;

import java.util.UUID;

import br.uece.me.model.enumeration.Tarifa;
import lombok.Data;

@Data
public class Usuario {
	
	private UUID id;
	
	private String nome;
	
	private CartaoEmbarque cartaoEmbarque;

	private CartaoCredito cartaoCredito;

	private String cpf;

	private Tarifa tarifa;

	public Usuario() {
		this.id = UUID.randomUUID();
	}

}
