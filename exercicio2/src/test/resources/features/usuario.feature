# language: pt
  @UsuarioTeste
  Funcionalidade: Cadastro de usuário
    US01: COMO um usuário EU PRECISO me cadastrar PARA que eu possa utilizar o metrô;
		Critérios de aceitação:
		O usuário deve informar o nome, cpf e cartão de crédito
		O cartão de crédito deve ser válido.
		O usuário deve escolher qual tarifa vai usar (única, diária, semanal, mensal);
		O usuário deve cadastrar o cartão de crédito no sistema;
		
   Esquema do Cenario: Validar inclusao/edição/exclusão de usuário - "<mensagem_esperada>"
      Dado que é necessário validar com "<tipo_operacao>" ao "<operacao>" o usuário
      Quando os seguintes dados foram adicionados: nome "<nome>",  cartão de embarque "<cartao_embarque>", cartão de crédito "<cartao_credito>", CPF "<cpf>" e tarifa "<tarifa>"
      Entao o sistema retorna a seguinte mensagem "<mensagem_esperada>" 

		  Exemplos:
		  | nome     | cartao_embarque | cartao_credito   | cpf         | tarifa  | operacao |tipo_operacao| mensagem_esperada			       																												|
		  |          | 1 		           | 5137366810814608 | 35420898004 | DIARIO  | incluir  | erro | Obrigatório informar o nome |
		  | Maria    | 1 		           |                  | 35420898004 | DIARIO  | incluir  | erro | Obrigatório informar o cartao de crédito |
		  | João     | 1 		           | 5137366810814608 |             | DIARIO  | incluir  | erro | Obrigatório informar o CPF |
		  | Xuxa     | 1 		           | 5137366810814608 | 35420898004 |         | incluir  | erro | Obrigatório informar a tarifa |
		  | Brendo   |   		           | 5137366810814608 | 35420898004 | DIARIO  | incluir  | sucesso | Operação incluir usuário realizada com sucesso |
		  | Angélica | 1 		           | 5137366810814608 | 35420898004 | DIARIO  | incluir  | sucesso | Operação incluir usuário realizada com sucesso |
		  | Eliane   | 2			         | 5137366810814608 | 35420898004 | SEMANAL | editar   | sucesso | Operação editar usuário realizada com sucesso |
		  | Faustão  | 2			         | 5137366810814608 | 35420898004 | SEMANAL | remover  | sucesso | Operação remover usuário realizada com sucesso |
