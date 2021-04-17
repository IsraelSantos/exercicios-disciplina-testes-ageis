package br.uece.me.mock;

import br.uece.me.model.CartaoCredito;
import br.uece.me.model.CartaoCredito.Bandeira;
import br.uece.me.model.CartaoEmbarque;
import br.uece.me.model.Usuario;
import br.uece.me.model.enumeration.Tarifa;

public class UsuarioMock {

	public static  Usuario newUsuario() {
		Usuario usuario;
		usuario = new Usuario();
		usuario.setNome("Fulano");
		usuario.setCpf("98605121084");
		
		usuario.setCartaoCredito(new CartaoCredito());
		usuario.getCartaoCredito().setNumero("4024007136494753");
		usuario.getCartaoCredito().setBandeira(Bandeira.VISA);
		
		usuario.setTarifa(Tarifa.SEMANAL);
		
		usuario.setCartaoEmbarque(new CartaoEmbarque());
		usuario.getCartaoEmbarque().setCodigo("5");
		return usuario;
	}

}
