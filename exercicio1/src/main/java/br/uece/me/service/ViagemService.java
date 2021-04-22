package br.uece.me.service;

import java.util.Objects;

import br.uece.me.model.Viagem;
import br.uece.me.util.Util;

public class ViagemService {

	public void validarEmbarque(Viagem viagem) {
		
		if(Objects.isNull(viagem.getDataEmbarque()))
			throw new RuntimeException("Data de embarque obrigatória no início da viagem");
		
		if(Objects.isNull(viagem.getEstacaoEmbarque()))
			throw new RuntimeException("Estacao de embarque é obrigatória no início da viagem");
		
		if(Objects.isNull(viagem.getUsuario()))
			throw new RuntimeException("Usuário obrigatório no registro da viagem");
		
	}

	public void validarDesembarque(Viagem viagem) {
		
		validarEmbarque(viagem);

		if(Objects.isNull(viagem.getDataDesembarque()))
			throw new RuntimeException("Data de desembarque obrigatória no fim da viagem");
		
		if(Objects.isNull(viagem.getEstacaoDesembarque()))
			throw new RuntimeException("Estacao de desembarque é obrigatória no fim da viagem");
		
		if(Util.dateAfter(viagem.getDataEmbarque(), viagem.getDataDesembarque())) 
			throw new RuntimeException("Data de desembarque não pode ser anterior ao embarque");
		
	}
	
	public void registrarEmbarque(Viagem viagem) {
		validarEmbarque(viagem);
		
		//Salvar viagem
	}
	
	public void registrarDesembarque(Viagem viagem) {
		validarDesembarque(viagem);
		
		//Salvar viagem
	}

}
