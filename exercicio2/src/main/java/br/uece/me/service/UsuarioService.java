package br.uece.me.service;

import java.util.Objects;

import br.uece.me.model.Usuario;
import br.uece.me.util.ValidaCartaoCreditoUtil;


public class UsuarioService {
	
	public void validarInclusaoUsuario(Usuario usuario) {
		
		if(Objects.isNull(usuario.getNome()) || usuario.getNome().trim().equals("")  )
			throw new RuntimeException("Obrigatório informar o nome");

		else if(Objects.isNull(usuario.getTarifa()))
			throw new RuntimeException("Obrigatório informar a tarifa");
		else if(Objects.isNull(usuario.getCpf())  || usuario.getCpf().trim().equals(""))
			throw new RuntimeException("Obrigatório informar o CPF");
		else
			validarCartaoDeCredito(usuario);
		
	}

	public void validarCartaoDeCredito(Usuario usuario) {
			
			if(Objects.isNull(usuario.getCartaoCredito()) || usuario.getCartaoCredito().getNumero().trim().equals(""))
				throw new RuntimeException("Obrigatório informar o cartao de crédito");
	
			else if(!ValidaCartaoCreditoUtil.isCartaoValido( usuario.getCartaoCredito().getNumero() ) )
				throw new RuntimeException("Cartão de crédito inválido");
	
	}

	public String salvar(Usuario usuario) {
		validarInclusaoUsuario(usuario);
		return "Operação realizada com sucesso";
		//TODO SALVAR USUÁRIO
	}
	
	
	public String editar(Usuario usuario) {
		validarInclusaoUsuario(usuario);
		return "Operação realizada com sucesso";
		//TODO EDITAR USUÁRIO
	}
	
	public String remover(Usuario usuario) {
		validarInclusaoUsuario(usuario);
		return "Operação realizada com sucesso";
		//TODO EDITAR USUÁRIO
	}
}
