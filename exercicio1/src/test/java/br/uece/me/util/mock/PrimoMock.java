package br.uece.me.util.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Universidade Estadual do Ceará
 * Especialização Engenharia de Software com Devops
 * Profª: Ludmila Varela de Castro
 * Disciplina Testes Ágeis
 * Teste unitário - números primos
 * @author marcos.eduardo
 */
public class PrimoMock {
	
	//https://www.ime.unicamp.br/~ftorres/ENSINO/CURSOS/primos.pdf
	private static List<Integer> primosAte100 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

	public static List<Integer> getPrimosAte100() {
		return primosAte100;
	}

	public static List<Integer> criarListaNumeroMock() {
		List<Integer> numeros;
		numeros = new ArrayList<>();
		for (int i = 0; i <= 100; i++)
			numeros.add(i);
		return numeros;
	}
	
	public static Integer somarNumeroEnTreZeroE100() {
		int soma = 0;
		for (Integer primo : primosAte100)
			soma += primo;
		return soma;
	}
	
}
