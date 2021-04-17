package br.uece.me.model;

import java.util.UUID;

import br.uece.me.model.enumeration.Zona;
import lombok.Data;

@Data
public class Estacao {

	private UUID id;
	
	private String nome;
	private String endereco;
	private String contato;
	private Zona zona;
	
	public Estacao() {
		this.id = UUID.randomUUID();
	}
	
	

}
