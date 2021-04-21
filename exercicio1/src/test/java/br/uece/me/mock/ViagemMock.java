package br.uece.me.mock;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import br.uece.me.model.Viagem;
import br.uece.me.util.Util;

public class ViagemMock {

	public static Viagem newViagem() {
		Viagem viagem = new Viagem();
		viagem.setEstacaoEmbarque(EstacaoMock.newEstacao());
		viagem.setEstacaoDesembarque(EstacaoMock.newEstacao());
		viagem.setDataEmbarque(Util.setData(new Date(), 1, 1, 2021, 11, 0));
		viagem.setDataDesembarque(Util.setData(new Date(), 1, 1, 2021, 13, 0));
		viagem.setUsuario(UsuarioMock.newUsuario());
		viagem.getUsuario().setId(new UUID(1,1));
		return viagem;
	}

	public static List<Viagem> newViagens() {
		List<Viagem> res = new LinkedList<Viagem>();
		for (int i = 0; i < 10; i++) {
			Viagem tmp = newViagem();
			tmp.setDataEmbarque(Util.setData(tmp.getDataEmbarque(), 1, 1, 2021, 10+i, 0));
			tmp.setDataDesembarque(Util.setData(tmp.getDataDesembarque(), 1, 1, 2021, 11+i, 0));
			res.add(tmp);
		}
		return res;
	}

}
