package br.uece.me.model;

import lombok.Data;

@Data
public class CartaoCredito {
	public enum Bandeira {MASTERCARD, VISA, AMERICAN}
	private String numero;
	private Bandeira bandeira;
}
