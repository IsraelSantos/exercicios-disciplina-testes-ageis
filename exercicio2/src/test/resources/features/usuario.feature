# language: pt
@RunUsuarioCucumberTest
Funcionalidade: Testar cadastro de usuario
  COMO um usuário eu PRECISO me cadastrar no sistema PARA que eu possa utilizar o metrô.

    Esquema do Cenario: Testar cadastro de usuario
      Dado A criação de um usuário de <nome>, cartão com embarque <cartaoEmbarque>, 
      Quando a <tarifa> é escolhida
      E a <cartaoEmbarque> foi criado
      E o dono realiza o segundo saque no valor de <segundo_saque> na conta
      Entao o dono tem o saldo no valor de <saldo_esperado> na conta

Exemplos:
|	nome	| cartaoEmbarque | cartaoCredito | cpf | tarifa
| João	| 1	|	1	|	21547896321 | UNICO |
| Maria	| 2	|	2	|	21547896321 | DIARIO	|
| João Maria	| 3	|	3	|	21546596321 | MENSAL	|
| José	| 4	|	4	|	21547456321 | SEMANAL	|
    

# **US01: COMO um usuário EU PRECISO me cadastrar no sistema PARA que eu possa utilizar o metrô;**

# Critérios de aceitação:
# - O usuário deve escolher qual tarifa vai usar (única, diária, semanal, mensal);
# - O usuário deve cadastrar o cartão de crédito no sistema;
# - O cartão de crédito deve ser validado.