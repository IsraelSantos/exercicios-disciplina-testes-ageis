package br.uece.me.cucumber.passos;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import br.uece.me.mock.PagamentoMock;
import br.uece.me.mock.ViagemMock;
import br.uece.me.model.Pagamento;
import br.uece.me.model.Viagem;
import br.uece.me.model.enumeration.Tarifa;
import br.uece.me.model.enumeration.Zona;
import br.uece.me.service.PagamentoService;
import br.uece.me.util.Util;
import cucumber.api.java8.Pt;

public class PagamentoTestePassos implements Pt{
	
	Pagamento pagamento = null;
	Viagem novaViagem = null;
	List<Viagem> viagensAnteriores = null;
	Pagamento ultimoPagamento = null;
	PagamentoService pagamentoService = new PagamentoService();
	
	public PagamentoTestePassos() {
		
		Dado("o pagamento criado sem valor, a abrangencia {string} e o usuário {string}", (String abrangencia, String usuarioid) -> {
			pagamento = PagamentoMock.newPagamento();
			pagamento.setValor(null);
			pagamento.getUsuario().setId(UUID.fromString(usuarioid));
			pagamento.setAbrangencia(Zona.valueOf(abrangencia));
		});

		Entao("é realizado a verificação do valor e na ausência de valor o sistema retorna {string}", (String mensagem) -> {
			assertThatThrownBy(() -> {pagamentoService.validarPagamento(pagamento);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(mensagem);
		});

		Dado("o pagamento criado com valor {bigdecimal}, sem abrangencia e o usuário {string}", (BigDecimal valor, String usuarioid) -> {
			pagamento = PagamentoMock.newPagamento();
			pagamento.setValor(valor);
			pagamento.getUsuario().setId(UUID.fromString(usuarioid));
			pagamento.setAbrangencia(null);
		});

		Entao("é realizado a verificação da abrangencia e na ausência de abrangencia o sistema retorna {string}", (String mensagem) -> {
			assertThatThrownBy(() -> {pagamentoService.validarPagamento(pagamento);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(mensagem);
		});

		Dado("o pagamento criado com o valor {bigdecimal}, a abrangencia {string} e sem usuário", (BigDecimal valor, String abrangencia) -> {
			pagamento = PagamentoMock.newPagamento();
			pagamento.setValor(valor);
			pagamento.setUsuario(null);
			pagamento.setAbrangencia(Zona.valueOf(abrangencia));
		});

		Entao("é realizada a verificação do usuário e na ausêcia de usuário o sistema retorna {string}", (String mensagem) -> {
			assertThatThrownBy(() -> {pagamentoService.validarPagamento(pagamento);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(mensagem);
		});
		
		Dado("a criação de uma nova viagem com tarifa {string} e zona {string} sem viagens anteriores para a tarifa", (String tarifa, String zona) -> {
			novaViagem = ViagemMock.newViagem();
			novaViagem.getUsuario().setTarifa(Tarifa.valueOf(tarifa));
			novaViagem.getEstacaoEmbarque().setZona(Zona.valueOf(zona));
			novaViagem.getEstacaoDesembarque().setZona(Zona.valueOf(zona));
			
			novaViagem.setDataEmbarque(Util.setData(novaViagem.getDataEmbarque(), 1, 1, 2021, 9, 0));
			novaViagem.setDataDesembarque(Util.setData(novaViagem.getDataDesembarque(), 1, 1, 2021, 10, 0));
			
			//TODO: Passar essa lista via mokito posteriormente
			viagensAnteriores = ViagemMock.newViagens();
			viagensAnteriores.clear();
		});
		
		Dado("a criação de uma nova viagem com tarifa {string} e zona {string} com viagens anteriores na mesma tarifa {string}", (String tarifa, String zona, String situacaoViagens) -> {
			novaViagem = ViagemMock.newViagem();
			novaViagem.getUsuario().setTarifa(Tarifa.valueOf(tarifa));
			
			novaViagem.setDataEmbarque(Util.setData(novaViagem.getDataEmbarque(), 1, 1, 2021, 9, 0));
			novaViagem.setDataDesembarque(Util.setData(novaViagem.getDataDesembarque(), 1, 1, 2021, 10, 0));
			novaViagem.getEstacaoEmbarque().setZona(Zona.valueOf(zona));
			
			//TODO: Passar essa lista via mokito posteriormente
			viagensAnteriores = ViagemMock.newViagens();
			switch (situacaoViagens) {
				case "COM_VIAGENS_ANTERIORES":
					viagensAnteriores.forEach(viagem -> {
						viagem.getUsuario().setTarifa(Tarifa.valueOf(tarifa));
					});
					ultimoPagamento = PagamentoMock.newPagamento();
					break;
				case "SEM_VIAGENS_ANTERIORES":
					viagensAnteriores.clear();
					ultimoPagamento = null;
					break;
			}
			
		});

		Entao("o valor do pagamento será {int}", (Integer valorT) -> {
			BigDecimal valor = new BigDecimal(valorT);
			BigDecimal valorASerPago = pagamentoService.calculaPagamentoInstantaneo(novaViagem, viagensAnteriores, ultimoPagamento);
			
			assertEquals("A tarifa deve conter o valor de acordo com a zona tarifaria", valor, valorASerPago);
		});
		
	}
}
