package br.uece.me.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.uece.me.mock.EstacaoMock;
import br.uece.me.model.Estacao;
import br.uece.me.service.EstacaoService;

/**
 * US02: COMO o administrador do sistema EU PRECISO cadastrar estações PARA identificar a zona tarifária de cada uma
 * @author israel.santos
 * @author marcos.eduardo
 */
public class EstacaoTest {
	
	private EstacaoService  estacaoService= new EstacaoService();

	@Test
	@DisplayName("O administrador do sistema deve incluir os dados necessários para funcionar a estação (nome, endereço, contato) e selecionar a zona tarifária da estação (Zona A e Zona B)")
	public void testeCadastroEstacao(){ 		
		
		Estacao e4 = EstacaoMock.newEstacao();		
		e4.setZona(null);
		Exception exception = assertThrows(RuntimeException.class, () -> estacaoService.validarInclusaoEstacao(e4));
		assertEquals("Obrigatório informar a Zona", exception.getMessage(), "Erro na operação 'estacaoService.validarInclusaoEstacao()'");						
			
		Estacao e1 = EstacaoMock.newEstacao();
		e1.setNome("123");
		exception = assertThrows(RuntimeException.class, () -> estacaoService.validarInclusaoEstacao(e1));
		assertEquals("O nome deve ter mais de 3 caracteres", exception.getMessage(), "Erro na operação 'estacaoService.validarInclusaoEstacao()'");		
		
		Estacao e2 = EstacaoMock.newEstacao();
		e2.setNome("  ");
		exception = assertThrows(RuntimeException.class, () -> estacaoService.validarInclusaoEstacao(e2));
		assertEquals("O nome da estação é obrigatório", exception.getMessage(), "Erro na operação 'estacaoService.validarInclusaoEstacao()'");

		Estacao e3 = EstacaoMock.newEstacao();
		e3.setNome(null);
		exception = assertThrows(RuntimeException.class, () -> estacaoService.validarInclusaoEstacao(e3));
		assertEquals("O nome da estação é obrigatório", exception.getMessage(), "Erro na operação 'estacaoService.validarInclusaoEstacao()'");

	}


}
