package br.uece.me.model;

import java.util.UUID;

import lombok.Data;

@Data
public class CartaoEmbarque {
	
	private UUID id;
	private String codigo;
	
	public CartaoEmbarque() {
		this.id = UUID.randomUUID();
	}

}
