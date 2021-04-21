
package br.uece.me.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import br.uece.me.mock.ViagemMock;
import br.uece.me.model.Viagem;
import br.uece.me.service.CalculoPagamentoService;
import br.uece.me.util.Util;

/**
 *
 * US04: COMO Sistema EU irei calcular o valor que o usuário vai pagar PARA realizar cobrança devida com base no uso do metrô;
 * 
 * @author israel.santos
 * @author marcos.eduardo
 */

@ExtendWith(MockitoExtension.class) 
public class CalculoPagamentoTest {
	
	CalculoPagamentoService calculoPagamentoService = new CalculoPagamentoService();

	@Test
	@DisplayName("A tarifa de um dia inclui todas as viagens individuais feitas em um único dia")
	public void testeViagensDia(){ 		
		Viagem novaViagem = ViagemMock.newViagem();
		
		novaViagem.setDataEmbarque(Util.setData(novaViagem.getDataEmbarque(), 1, 1, 2021, 9, 0));
		novaViagem.setDataDesembarque(Util.setData(novaViagem.getDataDesembarque(), 1, 1, 2021, 10, 0));
		
		//TODO: Passar essa lista via mokito posteriormente
		List<Viagem> viagensAnterioresDoDia = ViagemMock.newViagens();
		
		//Apenas a primeira viagem do dia numa mesma zona deve gerar cobrança
		BigDecimal valorASerPago = calculoPagamentoService.calculaPagamentoInstantaneo(novaViagem, viagensAnterioresDoDia);
		
		assertEquals(0, valorASerPago, "A tarifa de um dia inclui todas as viagens individuais feitas em um único dia");
	}
	
	@Test
	@DisplayName("A tarifa de uma semana inclui todas as viagens individuais feitas em uma única semana")
	public void testeViagensSemana(){ 		
		//assertEquals(esperado, atual, numero + " nao é primo");
		fail();
	}
	
	@Test
	@DisplayName("A tarifa de um mês inclui todas as viagens individuais feitas em um único mês")
	public void testeViagensMes(){ 		
		//assertEquals(esperado, atual, numero + " nao é primo");
		fail();
	}
	
	@Test
	@DisplayName("Não importa quantas viagens sejam feitas dentro de um dos limites de tempo de uma zona específica, o preço será limitado à tarifa daquele período de tempo")
	public void testeLimitesPAgamentoViagensRealizadas(){ 		
		//assertEquals(esperado, atual, numero + " nao é primo");
		fail();
	}
}
