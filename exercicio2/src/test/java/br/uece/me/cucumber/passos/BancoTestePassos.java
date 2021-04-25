package br.uece.me.cucumber.passos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import br.uece.me.model.Banco;
import br.uece.me.model.Conta;
import cucumber.api.java8.Pt;
import io.cucumber.datatable.DataTable;

public class BancoTestePassos implements Pt {

       private Banco banco;
       private Integer totalContas;
       private Double totalDinheiro;
       
       public BancoTestePassos() {
    	   Dado("que as contas sao do {string}", (String nome, DataTable contas) -> {
    		   // Definição do banco e associando as contas
        	   List<List<String>> listaDeContas = contas.asLists(String.class);
        	   List<Conta> contasResposta = Conta.converteLista(listaDeContas);
        	   
               banco = new Banco(nome, contasResposta);
           });
    	   
    	   Dado("o calculo do total de contas criadas", () -> {
    		   totalContas = banco.getListaDeContas().size();
           });
    	   
    	   Entao("o total de contas e {int}", (Integer totalContasEsperado) -> {
    		   assertEquals("O cálculo do total de contas está incorreto",
    		             totalContasEsperado, totalContas);
    	   });
    	   
    	   Dado("o calculo do total de dinheiro", () -> {
    		   totalDinheiro = banco.getListaDeContas().stream().mapToDouble
    		             (c -> c.getSaldo()).sum();
           });
    	   
    	   Entao("o total de dinheiro no banco e {double}", (Double totalDinheiroEsperado) -> {
    		   assertEquals("O cálculo do total de dinheiro no banco " + banco.getNome()
               + " está incorreto",
               totalDinheiroEsperado, totalDinheiro);
    	   });
       }

}