
package br.uece.me.testes;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * US04: COMO Sistema EU irei calcular o valor que o usuário vai pagar PARA realizar cobrança devida com base no uso do metrô;
 * 
 * @author israel.santos
 * @author marcos.eduardo
 */
public class CalculoPagamentoTest {

	@Test
	@DisplayName("A tarifa de um dia inclui todas as viagens individuais feitas em um único dia")
	public void testeViagensDia(){ 		
		//assertEquals(esperado, atual, numero + " nao é primo");
		fail();
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
