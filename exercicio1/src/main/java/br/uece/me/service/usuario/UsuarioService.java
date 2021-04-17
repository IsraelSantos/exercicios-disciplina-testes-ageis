package br.uece.me.service.usuario;

import java.util.Objects;

import br.uece.me.model.Usuario;
import br.uece.me.util.ValidaCartaoCreditoUltil;


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
				throw new RuntimeException("Cartão de crédito o brigatório");
	
			if(!ValidaCartaoCreditoUltil.isCartaoValido( usuario.getCartaoCredito().getNumero() ) )
				throw new RuntimeException("Cartão de crédito inválido");
	
	}
	
}
