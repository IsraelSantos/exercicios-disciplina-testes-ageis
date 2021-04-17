package br.uece.me.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.uece.me.mock.UsuarioMock;
import br.uece.me.model.Usuario;
import br.uece.me.service.usuario.UsuarioService;
import br.uece.me.util.ValidaCartaoCreditoUltil;

/**
 * US01: COMO um usuário EU PRECISO me cadastrar no sistema PARA que eu possa utilizar o metrô
 * @author israel.santos
 */
public class UsuarioTest {
	
	UsuarioService usuarioService = new UsuarioService();

	@Test
	@DisplayName("Deve verificar se o usuário incluiu o cartão de crédito válido no momento do cadastro")
	public void testeCartaoDeCreditoObrigatorio() {
		
		Usuario usuario = UsuarioMock.newUsuario();
		usuario.getCartaoCredito().setNumero("123");
		
		Exception exception = assertThrows(RuntimeException.class, () -> usuarioService.validarCartaoDeCredito(usuario));
		assertEquals("Cartão de crédito inválido", exception.getMessage(), "Erro: Cartão de crédito inválido");
		
		usuario.setCartaoCredito(null);
		exception = assertThrows(RuntimeException.class, () -> usuarioService.validarCartaoDeCredito(usuario));
		assertEquals("Cartão de crédito o brigatório", exception.getMessage(), "Erro: Cartão de crédito nulo");
		
	}

	
//	throw new RuntimeException("Cartão de crédito o brigatório");
//	
//if( ValidaCartaoCreditoUltil.validar( usuario.getCartaoCredito().getNumero() ) )
//	throw new RuntimeException("Cartão de crédito inválido");
	
	
	@DisplayName("O usuário deve escolher qual tarifa vai usar (única, diária, semanal, mensal)")
	@Test
	public void testeValidacaoTarifa(){
		
		Usuario usuario = UsuarioMock.newUsuario();
		
		usuario.setTarifa(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> usuarioService.validarInclusaoUsuario(usuario));
		assertEquals("Tarifa inválida", exception.getMessage(), "Erro: Tarifa inválida!");
		
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
