package br.uece.me.testes;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

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

	@Test
//	@DisplayName("O usuário deve escolher qual tarifa vai usar (única, diária, semanal, mensal)")
	public void testeValidacaoTarifa(){
		
		Usuario usuario = UsuarioMock.newUsuario();
		usuario.setTarifa(null);
		
		assertThatThrownBy(() -> {usuarioService.validarInclusaoUsuario(usuario);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Tarifa inválida");	

	}	
	
	@Test
//	@DisplayName("O usuário deve cadastrar o cartão de crédito no sistema")
	public void testeTipoTarifaObrigatoria(){
		
		Usuario usuario = UsuarioMock.newUsuario();
		usuario.setCartaoCredito(null);

		assertThatThrownBy(() -> {usuarioService.validarCartaoDeCredito(usuario);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Cartão de crédito obrigatório");
	
	}
    
	
	@Test
//	@DisplayName("O cartão de crédito deve ser validado")
	public void testeCartaoValido(){

		Usuario usuario = UsuarioMock.newUsuario();
		usuario.getCartaoCredito().setNumero("123");	
		
		assertThatThrownBy(() -> {usuarioService.validarCartaoDeCredito(usuario);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Cartão de crédito inválido");
		
	}
	
}
