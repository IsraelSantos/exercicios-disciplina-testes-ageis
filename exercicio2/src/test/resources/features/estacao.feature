# language: pt
@EstacaoTeste
  Funcionalidade: Cadastro de estação
    US02: COMO o administrador do sistema EU PRECISO cadastrar estações PARA identificar a zona tarifária de cada uma
		Critérios de aceitação:
		- O administrador do sistema deve incluir os dados necessários para funcionar a estação (nome, endereço, contato) e selecionar a zona tarifária da estação (Zona A e Zona B)

    Cenario: Testar cadastro de estação sem zona
    	Dado a estacao criada sem zona
    	Entao é realizada a verificação da zona e o sistema deve retornar "Obrigatório informar a Zona"
    	
   Cenario: Testar cadastro de estação com nome vazio
    	Dado a estacao criada com nome vazio
    	Entao é realizada a verificação do nome e o sistema deve retornar "O nome da estação é obrigatório"
    	
    Cenario: Testar cadastro de estação com nome nulo
    	Dado a estacao criada com nome nulo
    	Entao é realizada a verificação do nome e o sistema deve retornar "O nome da estação é obrigatório"
    	
    Cenario: Testar cadastro de estação com nome inconsistente
    	Dado a estacao criada com nome inconsistente
    	Entao é realizada a verificação do nome e o sistema deve retornar "O nome deve ter mais de 3 caracteres"
    