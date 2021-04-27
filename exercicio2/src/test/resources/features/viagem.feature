# language: pt
  @PagamentoTeste
  Funcionalidade: Cadastro de viagem
    US03: COMO usuário EU PRECISO passar o cartão na catraca PARA registrar minha viagem;
		Critérios de aceitação:
		- Cada vez que o usuário entra no metrô o sistema deve registrar data de entrada na Viagem;
		- Cada vez que o usuário entra no metrô o sistema deve registrar a estação/zona tarifária de embarque na Viagem;
		- Cada vez que o usuário sai do metrô o sistema deve registrar a estação/zona tarifária de desembarque na Viagem;
		- Cada vez que o usuário sai do metrô o sistema deve registrar data de desembarque na Viagem;
		- Ao registrar o desembarque o horário nunca deve ser anterior ao de embarque.

    Cenario: Testar cadastro de viagem sem data de entrada no embarque
    	Dado a viagem criada sem data de embarque no embarque
    	Entao é realizada a verificação da data de embarque e o sistema deve retornar "Data de embarque obrigatória no início da viagem"
    	
    Cenario: Testar cadastro de viagem sem estação de embarque no embarque
    	Dado a viagem criada sem estação de embarque no embarque
    	Entao é realizada a verificação da estação de embarque e o sistema deve retornar "Estacao de embarque é obrigatória no início da viagem"
    
    Cenario: Testar atualizacao de viagem sem estação de desembarque no desembarque
    	Dado a viagem atualizada sem estação de desembarque no desembarque
    	Entao é realizada a verificação da estação de desembarque e o sistema deve retornar "Estacao de desembarque é obrigatória no fim da viagem"
    	
    Cenario: Testar atualizacao de viagem sem data de desembarque no desembarque
    	Dado a viagem atualizada sem data de desembarque no desembarque
    	Entao é realizada a verificação da data de desembarque e o sistema deve retornar "Data de desembarque obrigatória no fim da viagem"
    		
    Cenario: Testar inconcistente horario de desembarque no cadastro do desembarque
    	Dado a viagem atualizada com data de embarque "01/01/2021 11:20" e data de desembarque "01/01/2021 10:20"
    	Entao é realizada a verificação das datas e o sistema deve retornar "Data de desembarque não pode ser anterior ao embarque"
    	
    Cenario: Testar cadastro de viagem sem usuario no embarque
    	Dado a viagem criada sem usuário no embarque
    	Entao é realizada a verificação do usuário no embarque e o sistema deve retornar "Usuário obrigatório no registro da viagem"
    
    Cenario: Testar cadastro de viagem sem usuario no desembarque
    	Dado a viagem criada sem usuário no desembarque
    	Entao é realizada a verificação do usuário no desembarque e o sistema deve retornar "Usuário obrigatório no registro da viagem"
    
