package br.uece.me.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Conta {

       private String dono;
       private Integer numero;
       private Double saldo;
       private Double limite;
       
       public Conta() {
    	   
       }

       public Conta(String dono, int numero, Double limite, Double saldo) {
             this.dono = dono;
             this.numero = numero;
             this.saldo = saldo;
             this.limite = limite;

       }

       public boolean sacar(Double valor) {
             if (saldo <= valor) {
                    // Não pode sacar
                    return false;
             } else {
                    // Pode sacar
                    saldo = saldo - valor;
                    return true;
             }
       }

       public boolean depositar(Double quantidade) {

             if (limite <= quantidade + saldo) {
                    // Não pode depositar
                    return false;
             } else {
                    // Pode depositar
                    saldo += quantidade;
                    return true;
             }
       }
       
       public static List<Conta> converteLista(List<List<String>> listaDeContas) {
   		List<Conta> contasResposta = new LinkedList<Conta>();
       	   
       	   listaDeContas.forEach((lconta) -> {
       		   if (!Objects.equals(lconta.get(0), "dono")) {
       			   Conta conta = new Conta();
   				   conta.setDono(lconta.get(0));
   				   conta.setNumero(Integer.valueOf(lconta.get(1)));
   				   conta.setLimite(Double.valueOf(lconta.get(2)));
   				   conta.setSaldo(Double.valueOf(lconta.get(3)));
   				   contasResposta.add(conta);
       		   }
       	   });
   		return contasResposta;
   	}

       public String getDono() {
             return dono;
       }

       public void setDono(String dono) {
             this.dono = dono;
       }

       public Integer getNumero() {
             return numero;
       }

       public void setNumero(Integer numero) {
             this.numero = numero;
       }

       public Double getSaldo() {
             return saldo;
       }

       public void setSaldo(Double saldo) {
             this.saldo = saldo;
       }

       public Double getLimite() {
             return limite;
       }

       public void setLimite(Double limite) {
             this.limite = limite;
       }
}