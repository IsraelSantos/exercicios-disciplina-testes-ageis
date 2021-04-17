package br.uece.me.model;

import br.uece.me.model.enumeration.Tarifa;
import lombok.Data;

@Data
public class Usuario {
	
	private String nome;
	
	private CartaoEmbarque cartaoEmbarque;

	private CartaoCredito cartaoCredito;

	private String cpf;

	private Tarifa tarifa;

}
