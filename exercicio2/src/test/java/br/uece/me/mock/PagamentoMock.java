package br.uece.me.mock;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import br.uece.me.model.Pagamento;
import br.uece.me.model.Usuario;
import br.uece.me.model.enumeration.Zona;

public class PagamentoMock {

	public static Pagamento newPagamento() {
		Pagamento res = new Pagamento();
		res.setValor(new BigDecimal(6));
		res.setAbrangencia(Zona.A);
		res.setUsuario(new Usuario());
		return res;
	}

	public static List<Pagamento> newPagamentos() {
		List<Pagamento> res = new LinkedList<Pagamento>();
		Pagamento tmp = newPagamento();
		res.add(tmp);
		return res;
	}

}
