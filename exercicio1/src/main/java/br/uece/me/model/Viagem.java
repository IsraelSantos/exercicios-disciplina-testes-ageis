package br.uece.me.model;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class Viagem {
	
	private UUID id;
	
	private Estacao estacaoEmbarque;
	
	private Estacao estacaoDesembarque;
	
	private Date dataEmbarque;
	
	private Date dataDesembarque;
	
	public Viagem() {
		this.id = UUID.randomUUID();
	}

}
