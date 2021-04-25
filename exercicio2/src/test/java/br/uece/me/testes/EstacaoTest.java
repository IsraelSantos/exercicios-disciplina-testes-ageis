package br.uece.me.testes;


import org.junit.Test;

import br.uece.me.mock.EstacaoMock;
import br.uece.me.model.Estacao;
import br.uece.me.service.EstacaoService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

/**
 * US02: COMO o administrador do sistema EU PRECISO cadastrar estações PARA identificar a zona tarifária de cada uma
 * @author israel.santos
 * @author marcos.eduardo
 */
public class EstacaoTest {
	
	private EstacaoService  estacaoService= new EstacaoService();

	@Test
	//@DisplayName("O administrador do sistema deve incluir os dados necessários para funcionar a estação (nome, endereço, contato) e selecionar a zona tarifária da estação (Zona A e Zona B)")
	public void testeCadastroEstacao(){ 		
		
		Estacao e4 = EstacaoMock.newEstacao();		
		e4.setZona(null);
		assertThatThrownBy(() -> {estacaoService.validarInclusaoEstacao(e4);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Obrigatório informar a Zona");						
		
		Estacao e1 = EstacaoMock.newEstacao();
		e1.setNome("123");
		assertThatThrownBy(() -> {estacaoService.validarInclusaoEstacao(e1);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("O nome deve ter mais de 3 caracteres");		
		
		Estacao e2 = EstacaoMock.newEstacao();
		e2.setNome("  ");
		assertThatThrownBy(() -> {estacaoService.validarInclusaoEstacao(e2);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("O nome da estação é obrigatório");

		Estacao e3 = EstacaoMock.newEstacao();
		e3.setNome(null);
		assertThatThrownBy(() -> {estacaoService.validarInclusaoEstacao(e3);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("O nome da estação é obrigatório");

	}


}
