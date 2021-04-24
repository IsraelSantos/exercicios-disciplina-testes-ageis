package br.uece.me.service;

import java.util.Objects;

import br.uece.me.model.Estacao;

public class EstacaoService {

	private static final int QTD_MIN_CARACTERS_NOME_ESTACAO = 3;

	public void validarInclusaoEstacao(Estacao estacao) {
		
		if(Objects.isNull(estacao.getNome()) || estacao.getNome().trim().equals(""))
			throw new RuntimeException("O nome da estação é obrigatório");

		if(estacao.getNome().trim().length() <= QTD_MIN_CARACTERS_NOME_ESTACAO)
			throw new RuntimeException("O nome deve ter mais de 3 caracteres");		
		
		if(Objects.isNull(estacao.getZona()))
			throw new RuntimeException("Obrigatório informar a Zona");		
	}

}
