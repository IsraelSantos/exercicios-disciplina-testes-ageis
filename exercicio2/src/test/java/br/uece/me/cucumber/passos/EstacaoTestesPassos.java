package br.uece.me.cucumber.passos;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import br.uece.me.mock.EstacaoMock;
import br.uece.me.model.Estacao;
import br.uece.me.service.EstacaoService;
import cucumber.api.java8.Pt;

public class EstacaoTestesPassos implements Pt{
	
	private Estacao estacao = null;
	private EstacaoService estacaoService = new EstacaoService();

	public EstacaoTestesPassos() {
		
		Dado("a estacao criada sem zona", () -> {
			estacao = EstacaoMock.newEstacao();		
			estacao.setZona(null);
		});

		Entao("é realizada a verificação da zona e o sistema deve retornar {string}", (String mensagem) -> {
			assertThatThrownBy(() -> {estacaoService.validarInclusaoEstacao(estacao);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(mensagem);		
		});

		Dado("a estacao criada com nome inconsistente", () -> {
			estacao = EstacaoMock.newEstacao();
			estacao.setNome("123");
		});
		
		Dado("a estacao criada com nome vazio", () -> {
			estacao = EstacaoMock.newEstacao();
			estacao.setNome("  ");
		});

		Entao("é realizada a verificação do nome e o sistema deve retornar {string}", (String mensagem) -> {
			assertThatThrownBy(() -> {estacaoService.validarInclusaoEstacao(estacao);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(mensagem);
		});

		Dado("a estacao criada com nome nulo", () -> {
			estacao = EstacaoMock.newEstacao();
			estacao.setNome(null);
		});

	}
	
}
