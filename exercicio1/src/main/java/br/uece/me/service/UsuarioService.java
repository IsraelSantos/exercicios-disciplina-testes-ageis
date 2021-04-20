package br.uece.me.service;

import java.util.Objects;

import br.uece.me.model.Usuario;
import br.uece.me.util.ValidaCartaoCreditoUtil;


public class UsuarioService {
	
	public void validarInclusaoUsuario(Usuario usuario) {
		
		validarCartaoDeCredito(usuario);
		
		if(Objects.isNull(usuario.getNome()))
			throw new RuntimeException("Nome é obrigatório");
		
		if(Objects.isNull(usuario.getTarifa()))
			throw new RuntimeException("Tarifa inválida");
		
	}

	public void validarCartaoDeCredito(Usuario usuario) {
			
			if(Objects.isNull(usuario.getCartaoCredito()))
				throw new RuntimeException("Cartão de crédito obrigatório");
	
			if(!ValidaCartaoCreditoUtil.isCartaoValido( usuario.getCartaoCredito().getNumero() ) )
				throw new RuntimeException("Cartão de crédito inválido");
	
	}
	
}
