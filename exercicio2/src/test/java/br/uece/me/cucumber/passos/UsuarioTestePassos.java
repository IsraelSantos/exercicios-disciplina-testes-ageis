package br.uece.me.cucumber.passos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import br.uece.me.model.Usuario;
import br.uece.me.service.UsuarioService;
import cucumber.api.java8.Pt;

public class UsuarioTestePassos implements Pt{
	
	private Usuario usuario = null;
	
	private String tipoOperacao = null, operacao = null; 
	
	private UsuarioService usuarioService = new UsuarioService();
	
	public UsuarioTestePassos() {
		
		Dado("que é necessário validar com {string} ao {string} o usuário", (String tipoOperacao, String operacao) -> {
			 usuario = new Usuario();
			 this.tipoOperacao = tipoOperacao;
			 this.operacao = operacao;
		});
		
		Quando("os seguintes dados foram adicionados: nome {string},  cartão de embarque {string}, cartão de crédito {string}, CPF {string}, tarifa {string}, login {string} e senha {string}", (String nome, String cartaoEmbarque, String cartaoCredito, String cpf,String tarifa,String login,String senha) -> {
			Usuario.addValores(usuario, nome, cartaoEmbarque, cartaoCredito, cpf, tarifa, login, senha);
		});
		
		Entao("o sistema retorna a seguinte mensagem {string}", (String msg) -> {
			
			if(tipoOperacao.equals("sucesso"))
				assertThat(executar(operacao)).isEqualTo(msg);
			else
				assertThatThrownBy(() -> { executar(operacao); }).isInstanceOf(RuntimeException.class).hasMessageContaining(msg);
		
		});
		
		
	}

	private String executar(String operacao) {
		
		String msgSucesso = "";
		
		if(operacao.equals("incluir"))
			msgSucesso = usuarioService.salvar(usuario);
		
		else if(operacao.equals("editar"))
			msgSucesso = usuarioService.editar(usuario);
		
		else if(operacao.equals("remover"))
			msgSucesso = usuarioService.remover(usuario);
		
		return msgSucesso;
	}

}
