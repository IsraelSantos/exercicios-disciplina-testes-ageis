# language: pt
  @PagamentoTeste
  Funcionalidade: Cadastro e calculo de pagamento
    COMO Sistema EU DEVO calcular o valor que o usuário vai pagar PARA realizar cobrança e registrar o pagamento devido com base no uso do metrô;
			Critérios de aceitação:
			- O pagamento deve conter o valor;
			- O pagamento deve conter a abrangencia (zona tarifária);
			- O pagamento deve conter o usuário que realizou;
			- A tarifa unica deve conter o valor de acordo com a zona tarifaria;
			- A tarifa de um dia inclui todas as viagens individuais feitas em um único dia;
			- A tarifa de uma semana inclui todas as viagens individuais feitas em uma única semana;
			- A tarifa de um mês inclui todas as viagens individuais feitas em um único mês;
			- O pagamento deve ser calculado, efetuado e registrado.

    Cenario: Testar cadastro de pagamento sem valor
      Dado o pagamento criado sem valor, a abrangencia "A" e o usuário "123e4567-e89b-12d3-a456-426614174000"
      Entao é realizado a verificação do valor e na ausência de valor o sistema retorna "Valor obrigatório ao registrar o pagamento"

    Cenario: Testar cadastro de pagamento sem abrangencia
      Dado o pagamento criado com valor 170.0, sem abrangencia e o usuário "123e4567-e89b-12d3-a456-426614174000"
      Entao é realizado a verificação da abrangencia e na ausência de abrangencia o sistema retorna "Abrangencia obrigatória ao registrar o pagamento"

    Cenario: Testar cadastro de pagamento sem usuario
      Dado o pagamento criado com o valor 170.0, a abrangencia "A" e sem usuário
      Entao é realizada a verificação do usuário e na ausêcia de usuário o sistema retorna "Usuario obrigatório ao registrar o pagamento"
      
    Cenario: Testar pagamento criado com tarifa UNICO
    	Dado a criação de uma nova viagem com tarifa "UNICO" e zona "A" sem viagens anteriores para a tarifa
    	Entao o valor do pagamento será 6

# O ultimo pagamento do próximo cenario ocorreu na zona A com valor 6, o pagamento deve ser a diferença entre o valor do pagamento atual e o último
    Esquema do Cenario: Testar pagamento criado com tarifa DIARIO, SEMANAL e MENSAL
    	Dado a criação de uma nova viagem com tarifa "<tarifa>" e zona "<zona>" com viagens anteriores na mesma tarifa "<viagens>"
    	Entao o valor do pagamento será <valor>
		Exemplos:
		| tarifa | zona | valor | viagens |
		| DIARIO | A | 0 | COM_VIAGENS_ANTERIORES |
		| SEMANAL | A | 0 | COM_VIAGENS_ANTERIORES |
		| MENSAL | A | 0 | COM_VIAGENS_ANTERIORES |
		| DIARIO | B | 6 | COM_VIAGENS_ANTERIORES |
		| SEMANAL | B | 39 | COM_VIAGENS_ANTERIORES |
		| MENSAL | B | 164 | COM_VIAGENS_ANTERIORES |
		| DIARIO | A | 10 | SEM_VIAGENS_ANTERIORES |
		| SEMANAL | A | 30 | SEM_VIAGENS_ANTERIORES |
		| MENSAL | A | 130 | SEM_VIAGENS_ANTERIORES |
		| DIARIO | B | 12 | SEM_VIAGENS_ANTERIORES |
		| SEMANAL | B | 45 | SEM_VIAGENS_ANTERIORES |
		| MENSAL | B | 170 | SEM_VIAGENS_ANTERIORES |
		

