package br.uece.me.util;

import java.util.Objects;

public class ValidaCartaoCreditoUtil {

	public static boolean isCartaoValido(String numero) {
		
		if(Objects.isNull(numero))
			return false;
		
		if(numero.length() < 16)
			return false;
		
		return true;
	}

}
