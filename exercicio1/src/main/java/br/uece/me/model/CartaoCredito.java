package br.uece.me.model;

import java.util.UUID;

import lombok.Data;

@Data
public class CartaoCredito {
	
	public enum Bandeira {MASTERCARD, VISA, AMERICAN}
	
	private UUID id;
	private String numero;
	private Bandeira bandeira;
	
	public CartaoCredito() {
		this.id = UUID.randomUUID();
	}
}
