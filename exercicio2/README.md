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


US01: COMO um usuário EU PRECISO me cadastrar no sistema PARA que eu possa utilizar o metrô;
Critérios de aceitação:
-O usuário deve escolher qual tarifa vai usar (única, diária, semanal, mensal);
-O usuário deve cadastrar o cartão de crédito no sistema;
-O cartão de crédito deve ser validado;

US02: COMO o administrador do sistema EU PRECISO cadastrar estações PARA identificar a zona tarifária de cada uma
Critérios de aceitação:
-O administrador do sistema deve selecionar a zona tarifária da estação (Zona A e Zona B);

US03: COMO usuário EU preciso passar o cartão na catraca PARA realizar minha viagem;
Critérios de aceitação:
-Cada vez que o usuário entra e sai do metrô o sistema deve guardar o registro de data de entrada e saida da Viagem bem como as zonas das estações;
-Dependendo da zona da estação o sistema registra a zona tarifária adotada para cobrança futura;

Obs.: Escrever a storie que calcula o quanto o usuário vai pagar.


### Regras de negócio

RN01: O cadastro de usuário deve exigir a inclusão do cartão de crédito;

RN02: Cada vez que o usuário entra e sai do metrô o sistema deve guardar o registro de data de entrada e saida da Viagem bem como as zonas das estações;