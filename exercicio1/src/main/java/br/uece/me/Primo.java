package br.uece.me;

import java.util.List;

/**
 * Universidade Estadual do Ceará
 * Especialização Engenharia de Software com Devops
 * Profª: Ludmila Varela de Castro
 * Disciplina Testes Ágeis
 * Teste unitário - números primos
 * @author marcos.eduardo
 */
public class Primo {
	
	public static boolean isPrimo(int numero) {
		
		if(numero == 0 || numero == 1)
			return false;
		
	    for (int j = 2; j < numero; j++)
	        if (numero % j == 0)
	            return false;   
	    return true;
	}

	public static Integer somarPrimos(List<Integer> numeros) {
		
		int soma = 0;
		
		for (Integer num : numeros)
			soma += (isPrimo(num) ? num : 0);

		return soma;
		//return 1060; TDD
	}
}
