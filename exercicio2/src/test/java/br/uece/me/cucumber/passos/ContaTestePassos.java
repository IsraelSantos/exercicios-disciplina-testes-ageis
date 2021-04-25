package br.uece.me.cucumber.passos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.uece.me.model.Conta;
import cucumber.api.java8.Pt;

public class ContaTestePassos implements Pt{

       private Conta conta;
       
       public ContaTestePassos() {
    	   Dado("a conta criada para o dono {string} de numero {int} com o limite {double} e saldo {double}", (String dono, Integer numero, Double limite,
                   Double saldo) -> {
                	// Definição de conta
                       conta = new Conta(dono, numero, limite, saldo);
           });
    	   
    	   Quando("o dono realiza o deposito no valor de {double} na conta", (Double valorDeposito) -> {
    		   assertTrue("O dono " + conta.getDono() + " não tem limite disponível na conta para este valor de deposito",
                       conta.depositar(valorDeposito));
           });
    	   
    	   E("o dono realiza o primeiro saque no valor de {double} na conta", (Double valorSaque) -> {
    		   assertTrue("O dono " + conta.getDono() + " não tem saldo disponível na conta para este valor de saque",
                       conta.sacar(valorSaque));
    	   });
    	   
       	   E("o dono realiza o segundo saque no valor de {double} na conta", (Double valorSaque) -> {
       		   assertTrue("O dono " + conta.getDono() + " não tem saldo disponível na conta para este valor de saque",
                    conta.sacar(valorSaque));
    	   });
    	   
           Entao("o dono tem o saldo no valor de {double} na conta", (Double saldoEsperado) -> {
                 assertEquals("O dono " + conta.getDono() + " está com o saldo incorreto na conta", saldoEsperado,
                               conta.getSaldo());
           });
    	   
	   }

//       @Dado("a conta criada para o dono {string} de numero {int} com o limite {} e saldo {}")
//       public void a_conta_criada_para_o_dono_de_numero_com_o_limite_e_saldo(String dono, int numero, Double limite,
//                    Double saldo) throws Throwable {
//             // Definição de conta
//             conta = new Conta(dono, numero, limite, saldo);
//       }
//
//       @Quando("o dono realiza o deposito no valor de {} na conta")
//       public void o_dono_realiza_o_deposito_no_valor_de_na_conta(Double valorDeposito) throws Throwable {
//             assertTrue("O dono " + conta.getDono() + " não tem limite disponível na conta para este valor de deposito",
//                           conta.depositar(valorDeposito));
//       }
//
//       @E("o dono realiza o primeiro saque no valor de {} na conta")
//       public void o_dono_realiza_o_primeiro_saque_no_valor_de_na_conta(Double valorSaque) throws Throwable {
//             assertTrue("O dono " + conta.getDono() + " não tem saldo disponível na conta para este valor de saque",
//                           conta.sacar(valorSaque));
//       }
//
//       @E("o dono realiza o segundo saque no valor de {} na conta")
//       public void o_dono_realiza_o_segundo_saque_no_valor_de_na_conta(Double valorSaque) throws Throwable {
//             assertTrue("O dono " + conta.getDono() + " não tem saldo disponível na conta para este valor de saque",
//                           conta.sacar(valorSaque));
//       }
//
//       @Entao("o dono tem o saldo no valor de {} na conta")
//       public void o_dono_tem_o_saldo_na_conta_no_valor_de(Double saldoEsperado) throws Throwable {
//             assertEquals("O dono " + conta.getDono() + " está com o saldo incorreto na conta", saldoEsperado,
//                           conta.getSaldo());
//       }
}