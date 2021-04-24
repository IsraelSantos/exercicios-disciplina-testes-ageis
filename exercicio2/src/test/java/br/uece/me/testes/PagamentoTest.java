
package br.uece.me.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.uece.me.mock.PagamentoMock;
import br.uece.me.mock.ViagemMock;
import br.uece.me.model.Pagamento;
import br.uece.me.model.Viagem;
import br.uece.me.model.enumeration.Tarifa;
import br.uece.me.model.enumeration.Zona;
import br.uece.me.service.PagamentoService;
import br.uece.me.util.Util;

/**
 *
 * US04: COMO Sistema EU DEVO calcular o valor que o usuário vai pagar PARA realizar cobrança e registrar o pagamento devido com base no uso do metrô;
 * 
 * @author israel.santos
 * @author marcos.eduardo
 */

public class PagamentoTest {
	
	PagamentoService pagamentoService = new PagamentoService();
	
	@Test
	@DisplayName("O pagamento deve conter o valor")
	public void testeResgistroValorPagamento(){
		Pagamento pagamento = PagamentoMock.newPagamento();
		pagamento.setValor(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> pagamentoService.validarPagamento(pagamento));
		assertEquals("Valor obrigatório ao registrar o pagamento", exception.getMessage(), "Erro ao validar pagamento - O pagamento deve conter o valor");
	}
	
	@Test
	@DisplayName("O pagamento deve conter a abrangencia (zona tarifária)")
	public void testeResgistroAbrangenciaPagamento(){
		Pagamento pagamento = PagamentoMock.newPagamento();
		pagamento.setAbrangencia(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> pagamentoService.validarPagamento(pagamento));
		assertEquals("Abrangencia obrigatória ao registrar o pagamento", exception.getMessage(), "Erro ao validar pagamento - Abrangencia obrigatória ao registrar o pagamento");
	}
	
	@Test
	@DisplayName("O pagamento deve conter o usuário que realizou")
	public void testeResgistroUsuarioPagamento(){
		Pagamento pagamento = PagamentoMock.newPagamento();
		pagamento.setUsuario(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> pagamentoService.validarPagamento(pagamento));
		assertEquals("Usuario obrigatório ao registrar o pagamento", exception.getMessage(), "Erro ao validar pagamento - Usuario obrigatória ao registrar o pagamento");
	}
	
	@Test
	@DisplayName("A tarifa unica deve conter o valor de acordo com a zona tarifaria")
	public void testeViagensUnico(){ 		
		Viagem novaViagem = ViagemMock.newViagem();
		novaViagem.getUsuario().setTarifa(Tarifa.UNICO);
		
		novaViagem.setDataEmbarque(Util.setData(novaViagem.getDataEmbarque(), 1, 1, 2021, 9, 0));
		novaViagem.setDataDesembarque(Util.setData(novaViagem.getDataDesembarque(), 1, 1, 2021, 10, 0));
		
		//TODO: Passar essa lista via mokito posteriormente
		List<Viagem> viagensAnteriores = ViagemMock.newViagens();
		viagensAnteriores.clear();
		
		BigDecimal valorASerPago = pagamentoService.calculaPagamentoInstantaneo(novaViagem, viagensAnteriores, null);
		
		assertEquals(new BigDecimal(6), valorASerPago, "A tarifa unica deve conter o valor de acordo com a zona tarifaria");
	}

	@Test
	@DisplayName("A tarifa de um dia inclui todas as viagens individuais feitas em um único dia")
	public void testeViagensDia(){ 		
		Viagem novaViagem = ViagemMock.newViagem();
		novaViagem.getUsuario().setTarifa(Tarifa.DIARIO);
		
		novaViagem.setDataEmbarque(Util.setData(novaViagem.getDataEmbarque(), 1, 1, 2021, 9, 0));
		novaViagem.setDataDesembarque(Util.setData(novaViagem.getDataDesembarque(), 1, 1, 2021, 10, 0));
		
		//TODO: Passar essa lista via mokito posteriormente
		List<Viagem> viagensAnterioresDoDia = ViagemMock.newViagens();
		viagensAnterioresDoDia.forEach(viagem -> {
			viagem.getUsuario().setTarifa(Tarifa.DIARIO);
		});
		
		Pagamento ultimoPagamentoNoDia = PagamentoMock.newPagamento(); // Se houve um pagamento na zona A, o novo pagamento será apenas a diferença.
		
		//Apenas a primeira viagem do dia numa mesma zona deve gerar cobrança
		BigDecimal valorASerPago = pagamentoService.calculaPagamentoInstantaneo(novaViagem, viagensAnterioresDoDia, ultimoPagamentoNoDia);
		
		assertEquals(new BigDecimal(0), valorASerPago, "A tarifa de um dia inclui todas as viagens individuais feitas em um único dia");
	}
	
	@Test
	@DisplayName("A tarifa de uma semana inclui todas as viagens individuais feitas em uma única semana")
	public void testeViagensSemana(){ 		
		Viagem novaViagem = ViagemMock.newViagem();
		novaViagem.getUsuario().setTarifa(Tarifa.SEMANAL);
		
		novaViagem.setDataEmbarque(Util.setData(novaViagem.getDataEmbarque(), 1, 1, 2021, 9, 0));
		novaViagem.setDataDesembarque(Util.setData(novaViagem.getDataDesembarque(), 1, 1, 2021, 10, 0));
		
		//TODO: Passar essa lista via mokito posteriormente
		List<Viagem> viagensAnterioresDaSemana = ViagemMock.newViagens();
		viagensAnterioresDaSemana.forEach(viagem -> {
			viagem.getUsuario().setTarifa(Tarifa.SEMANAL);
		});
		
		Pagamento ultimoPagamentoNoDia = PagamentoMock.newPagamento(); // Se houve um pagamento na zona A, o novo pagamento será apenas a diferença.
		
		//Apenas a primeira viagem da semana numa mesma zona deve gerar cobrança
		BigDecimal valorASerPago = pagamentoService.calculaPagamentoInstantaneo(novaViagem, viagensAnterioresDaSemana, ultimoPagamentoNoDia);
		
		assertEquals(new BigDecimal(0), valorASerPago, "A tarifa de uma semana inclui todas as viagens individuais feitas em uma única semana");
	}
	
	@Test
	@DisplayName("A tarifa de um mês inclui todas as viagens individuais feitas em um único mês")
	public void testeViagensMes(){ 		
		Viagem novaViagem = ViagemMock.newViagem();
		novaViagem.getUsuario().setTarifa(Tarifa.MENSAL);
		
		novaViagem.setDataEmbarque(Util.setData(novaViagem.getDataEmbarque(), 1, 1, 2021, 9, 0));
		novaViagem.setDataDesembarque(Util.setData(novaViagem.getDataDesembarque(), 1, 1, 2021, 10, 0));
		
		//TODO: Passar essa lista via mokito posteriormente
		List<Viagem> viagensAnterioresDoMes = ViagemMock.newViagens();
		viagensAnterioresDoMes.forEach(viagem -> {
			viagem.getUsuario().setTarifa(Tarifa.MENSAL);
		});
		
		Pagamento ultimoPagamentoNoDia = PagamentoMock.newPagamento(); // Se houve um pagamento na zona A, o novo pagamento será apenas a diferença.
		
		//Apenas a primeira viagem do mes numa mesma zona deve gerar cobrança
		BigDecimal valorASerPago = pagamentoService.calculaPagamentoInstantaneo(novaViagem, viagensAnterioresDoMes, ultimoPagamentoNoDia);
		
		assertEquals(new BigDecimal(0), valorASerPago, "A tarifa de um mês inclui todas as viagens individuais feitas em um único mês");
	}
	
	@Test
	@DisplayName("O pagamento deve ser calculado, efetuado e registrado")
	public void testeCalculoPagamento(){ 	
		Viagem novaViagem = ViagemMock.newViagem();
		novaViagem.getUsuario().setTarifa(Tarifa.MENSAL);
		
		novaViagem.setDataEmbarque(Util.setData(novaViagem.getDataEmbarque(), 1, 1, 2021, 9, 0));
		novaViagem.setDataDesembarque(Util.setData(novaViagem.getDataDesembarque(), 1, 1, 2021, 10, 0));
		novaViagem.getEstacaoEmbarque().setZona(Zona.B);
		
		
		//TODO: Passar essa lista via mokito posteriormente
		List<Viagem> viagensAnterioresDoMes = ViagemMock.newViagens();
		viagensAnterioresDoMes.clear();
		
		Pagamento ultimoPagamentoNoDia = null ;
		
		//Apenas a primeira viagem do mes numa mesma zona deve gerar cobrança
		BigDecimal valorASerPago = pagamentoService.registrarPagamento(novaViagem, viagensAnterioresDoMes, ultimoPagamentoNoDia);
		
		assertEquals(new BigDecimal(170), valorASerPago, "O pagamento deve ser calculado e efetuado e registrado");
	}
	
}
