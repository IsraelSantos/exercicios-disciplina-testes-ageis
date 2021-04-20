package br.uece.me.mock;

import java.util.Date;

import br.uece.me.model.Viagem;
import br.uece.me.util.Util;

public class ViagemMock {

	public static Viagem newViagem() {
		Viagem viagem = new Viagem();
		viagem.setEstacaoEmbarque(EstacaoMock.newEstacao());
		viagem.setEstacaoDesembarque(EstacaoMock.newEstacao());
		viagem.setDataEmbarque(Util.setData(new Date(), 1, 1, 2021, 11, 0));
		viagem.setDataDesembarque(Util.setData(new Date(), 1, 1, 2021, 13, 0));
		return viagem;
	}

}
