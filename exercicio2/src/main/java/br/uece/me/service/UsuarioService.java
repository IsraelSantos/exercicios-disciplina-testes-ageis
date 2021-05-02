package br.uece.me.service;

import java.util.Objects;

import br.uece.me.model.Usuario;
import br.uece.me.util.ValidaCartaoCreditoUtil;


public class UsuarioService {
	

	public String salvar(Usuario usuario) {
		validarInclusaoUsuario(usuario);
		return "Operação incluir usuário realizada com sucesso";
		//TODO SALVAR USUÁRIO
	}
	
	public String editar(Usuario usuario) {
		validarEdicaoUsuario(usuario);
		return "Operação editar usuário realizada com sucesso";
		//TODO EDITAR USUÁRIO
	}
	
	public String remover(Usuario usuario) {
		return "Operação remover usuário realizada com sucesso";
		//TODO EDITAR USUÁRIO
	}
	
	public void validarEdicaoUsuario(Usuario usuario) {
		validarInclusaoUsuario(usuario);
	}
	
	public void validarInclusaoUsuario(Usuario usuario) {
		
		if(Objects.isNull(usuario.getNome()) || usuario.getNome().trim().equals("")  )
			throw new RuntimeException("Obrigatório informar o nome");

		else if(Objects.isNull(usuario.getTarifa()))
			throw new RuntimeException("Obrigatório informar a tarifa");
		else if(Objects.isNull(usuario.getCpf())  || usuario.getCpf().trim().equals(""))
			throw new RuntimeException("Obrigatório informar o CPF");
		else
			if(Objects.isNull(usuario.getLogin()) || usuario.getLogin().trim().equals(""))
				throw new RuntimeException("Login obrigatório");
		else	
			if(Objects.isNull(usuario.getSenha()) || usuario.getSenha().trim().equals(""))
				throw new RuntimeException("Senha obrigatória");
		else
			validarCartaoDeCredito(usuario);
		
	}
	
	public void validarCartaoDeCredito(Usuario usuario) {
			
			if(Objects.isNull(usuario.getCartaoCredito()) || usuario.getCartaoCredito().getNumero().trim().equals(""))
				throw new RuntimeException("Obrigatório informar o cartao de crédito");
	
			else if(!ValidaCartaoCreditoUtil.isCartaoValido( usuario.getCartaoCredito().getNumero() ) )
				throw new RuntimeException("Cartão de crédito inválido");
	
	}


	
}
