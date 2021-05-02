package br.uece.me.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import br.uece.me.model.CartaoCredito.Bandeira;
import br.uece.me.model.enumeration.Tarifa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
public @Data class Usuario {
	
	private UUID id;
	
	private String nome;
	
	private CartaoEmbarque cartaoEmbarque;

	private CartaoCredito cartaoCredito;

	private String cpf;

	private Tarifa tarifa;
	
	private String login;
	
	private String senha;
	
	public Usuario() {
		this.id = UUID.randomUUID();
	}

	public Usuario(String nome, String cartaoEmbarque, String cartaoCredito, String cpf, String tarifa, String login, String senha) {
		super();
		
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		
		this.setCartaoCredito(new CartaoCredito());
		this.getCartaoCredito().setNumero(cartaoCredito);
		this.getCartaoCredito().setBandeira(Bandeira.VISA);
		
		this.setCartaoEmbarque(new CartaoEmbarque());
		this.getCartaoEmbarque().setCodigo(cartaoEmbarque);
		
		this.tarifa = Tarifa.valueOf(tarifa);
	}
	
	public static Usuario addValores(Usuario u, String nome, String cartaoEmbarque, String cartaoCredito, String cpf, String tarifa, String login, String senha) {
		u.nome = nome;
		u.cpf = cpf;
		u.login = login;
		u.senha = senha;
		u.setCartaoCredito(new CartaoCredito());
		u.getCartaoCredito().setNumero(cartaoCredito);
		u.getCartaoCredito().setBandeira(Bandeira.VISA);
		u.setCartaoEmbarque(new CartaoEmbarque());
		u.getCartaoEmbarque().setCodigo(cartaoEmbarque);
		u.tarifa = Objects.isNull(tarifa) || tarifa.trim().equals("") ? null : Tarifa.valueOf(tarifa);
		return u;
	}

	public static List<Usuario> converter(List<List<Object>> lista){
		List<Usuario> retorno = new LinkedList<Usuario>();
    	   
		lista.forEach((l) -> {
    		   if (!Objects.equals(l.get(0), "nome")) {
    			   retorno.add(new Usuario(
    					   l.get(0).toString(), 
    					   l.get(1).toString(), 
    					   l.get(2).toString(), 
    					   l.get(3).toString(),
    					   l.get(4).toString(),
    					   l.get(5).toString(),
    					   l.get(6).toString()));
    		   }
    	   });
		return retorno;
	}

}
