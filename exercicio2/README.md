# Execício 2

 * Universidade Estadual do Ceará
 * Especialização Engenharia de Software com Devops
 * Profª: Ludmila Varela de Castro
 * Disciplina Testes Ágeis
 * Teste unitário - Sistema de Metrô
 * @author marcos.eduardo
 * @author israel.santos
 
 
## Especificação do Sistema de Metrô
 
### User Stories


**US01: COMO um usuário EU PRECISO me cadastrar no sistema PARA que eu possa utilizar o metrô;**

Critérios de aceitação:
- O usuário deve escolher qual tarifa vai usar (única, diária, semanal, mensal);
- O usuário deve cadastrar o cartão de crédito no sistema;
- O cartão de crédito deve ser validado;

**US02: COMO o administrador do sistema EU PRECISO cadastrar estações PARA identificar a zona tarifária de cada uma**

Critérios de aceitação:
- O administrador do sistema deve incluir os dados necessários para funcionar a estação (nome, endereço, contato) e selecionar a zona tarifária da estação (Zona A e Zona B);

**US03: COMO usuário EU preciso passar o cartão na catraca PARA registrar minha viagem;**

Critérios de aceitação:
- Cada vez que o usuário entra e sai do metrô o sistema deve registrar data de entrada/saida e estação/zona tarifária da Viagem;

**US04: COMO Sistema EU irei calcular o valor que o usuário vai pagar PARA realizar cobrança devida com base no uso do metrô;**

Critérios de aceitação:
- A tarifa de um dia inclui todas as viagens individuais feitas em um único dia;
- A tarifa de uma semana inclui todas as viagens individuais feitas em uma única semana;
- A tarifa de um mês inclui todas as viagens individuais feitas em um único mês
- Não importa quantas viagens sejam feitas dentro de um dos limites de tempo de uma zona específica, o preço será limitado à tarifa daquele período de tempo;