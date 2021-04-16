package br.uece.me.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import br.uece.me.Primo;
import br.uece.me.util.mock.PrimoMock;

/**
 * Universidade Estadual do Ceará
 * Especialização Engenharia de Software com Devops
 * Profª: Ludmila Varela de Castro
 * Disciplina Testes Ágeis
 * Teste unitário - números primos
 * @author marcos.eduardo
 */
public class PrimoTest {

	@DisplayName("Teste se é primo entre 0 e 100")
	@RepeatedTest(101)
	public void isPrimoTest(RepetitionInfo info){
		int numero = info.getCurrentRepetition()-1;
		List<Integer> primosEntre0e100 = PrimoMock.getPrimosAte100();
		boolean esperado = primosEntre0e100.contains(numero);
		boolean atual = Primo.isPrimo(numero);
		assertEquals(esperado, atual, numero + " nao é primo");
	}

	@Test
	@DisplayName("Testa soma de números primos entre 0 e 100")
	public void somaDeListaDePrimos(){
		List<Integer> numeros = PrimoMock.criarListaNumeroMock(); 
		Integer atual = Primo.somarPrimos(numeros);		
		Integer esperado = PrimoMock.somarNumeroEnTreZeroE100();		
		assertEquals(esperado, atual, "A soma dos números primos entre 0 e 100 deveria ter retornado "+ esperado);
	}

}
