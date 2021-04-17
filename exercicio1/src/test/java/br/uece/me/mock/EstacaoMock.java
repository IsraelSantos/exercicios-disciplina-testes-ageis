package br.uece.me.mock;

import br.uece.me.model.Estacao;
import br.uece.me.model.enumeration.Zona;

public class EstacaoMock {

	public static Estacao newEstacao() {
		Estacao estacao = new Estacao();
		estacao.setNome("Estação Benfica");
		estacao.setEndereco("Benfica, Fortaleza - CE, 60020-181");
		estacao.setZona(Zona.A);
		return estacao;
	}
}
