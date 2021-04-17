package br.uece.me.testes;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

/**
 * US01: COMO um usuário EU PRECISO me cadastrar no sistema PARA que eu possa utilizar o metrô
 * @author israel.santos
 */
public class UsuarioTest {

	@Test
	@DisplayName("Deve verificar se o usuário incluiu o cartão de crédito obrigatório no momento do cadastro")
	public void testeCartaoDeCreditoObrigatorio(){
		
		//assertEquals(esperado, atual, numero + " nao é primo");
		fail();
	}
	
	@DisplayName("O usuário deve escolher qual tarifa vai usar (única, diária, semanal, mensal)")
	@Test
	public void testeSeValidacaoDoCartaoCredito(){
		
		//assertEquals(esperado, atual, numero + " nao é primo");
		fail();
	}
	
	@DisplayName("O usuário deve cadastrar o cartão de crédito no sistema")
	@Test
	public void testeTipoTarifaObrigatoria(){
		
		//assertEquals(esperado, atual, numero + " nao é primo");
		fail();
	}

	@DisplayName("O cartão de crédito deve ser validado")
	@Test
	public void testeCartaoValido(){
		
		//assertEquals(esperado, atual, numero + " nao é primo");
		fail();
	}
}
