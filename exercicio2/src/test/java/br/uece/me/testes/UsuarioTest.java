package br.uece.me.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.uece.me.mock.UsuarioMock;
import br.uece.me.model.Usuario;
import br.uece.me.service.UsuarioService;

/**
 * US01: COMO um usuário EU PRECISO me cadastrar no sistema PARA que eu possa utilizar o metrô
 * @author marcos.eduardo
 * @author israel.santos
 */
public class UsuarioTest {
	
	UsuarioService usuarioService = new UsuarioService();

	@DisplayName("O usuário deve escolher qual tarifa vai usar (única, diária, semanal, mensal)")
	@Test
	public void testeValidacaoTarifa(){
		
		Usuario usuario = UsuarioMock.newUsuario();
		usuario.setTarifa(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> usuarioService.validarInclusaoUsuario(usuario));
		assertEquals("Tarifa inválida", exception.getMessage(), "Erro ao validar inclusao de usuario");
		
	}	
	
	@DisplayName("O usuário deve cadastrar o cartão de crédito no sistema")
	@Test
	public void testeTipoTarifaObrigatoria(){
		
		Usuario usuario = UsuarioMock.newUsuario();
		usuario.setCartaoCredito(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> usuarioService.validarCartaoDeCredito(usuario));
		assertEquals("Cartão de crédito obrigatório", exception.getMessage(), "Erro na operação 'usuarioService.validarCartaoDeCredito()'");
	}
    
	
	@DisplayName("O cartão de crédito deve ser validado")
	@Test
	public void testeCartaoValido(){

		Usuario usuario = UsuarioMock.newUsuario();
		usuario.getCartaoCredito().setNumero("123");
		
		Exception exception = assertThrows(RuntimeException.class, () -> usuarioService.validarCartaoDeCredito(usuario));
		assertEquals("Cartão de crédito inválido", exception.getMessage(), "Erro na operação 'usuarioService.validarCartaoDeCredito()'");	
		
	}
	
}
