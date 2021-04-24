package br.uece.me.cucumber.passos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import br.uece.me.model.Banco;
import br.uece.me.model.Conta;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class BancoTestePassos {

       private Banco banco;
       private int totalContas;
       private Double totalDinheiro;

       @Dado("^que as contas sao do \"(.*?)\"$")
       public void que_as_contas_sao_do(String nome, DataTable contas) throws Throwable {
             // Definição do banco e associando as contas
    	   List<List<String>> listaDeContas = contas.asLists(String.class);
    	   List<Conta> contasResposta = Conta.converteLista(listaDeContas);
    	   
           banco = new Banco(nome, contasResposta);

       }

       @Dado("^o calculo do total de contas criadas$")
       public void o_calculo_do_total_de_contas_criadas() throws Throwable {
             totalContas = banco.getListaDeContas().size();
       }

       @Entao("^o total de contas e (\\d+)$")
       public void o_total_de_contas_e(int totalContasEsperado) throws Throwable {
             assertEquals("O cálculo do total de contas está incorreto",
             totalContasEsperado, totalContas);
       }

       @Dado("^o calculo do total de dinheiro$")
       public void o_calculo_do_total_de_dinheiro() throws Throwable {
             totalDinheiro = banco.getListaDeContas().stream().mapToDouble
             (c -> c.getSaldo()).sum();
       }

       @Entao("^o total de dinheiro no banco e (\\d+)$")
       public void o_total_de_dinheiro_no_banco_e(Double totalDinheiroEsperado)
         throws Throwable {

             assertEquals("O cálculo do total de dinheiro no banco " + banco.getNome()
              + " está incorreto",
              totalDinheiroEsperado, totalDinheiro);
       }
}