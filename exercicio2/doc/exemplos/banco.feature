# language: pt
@BancoTeste
Funcionalidade: Testar as operacoes basicas de banco
  O sistema deve prover operações básicas de banco de forma correta.

  Contexto: Cria todas as contas e associa ao banco
    Dado que as contas sao do "Banco do Brasil"
      | dono                       | numero | limite | saldo |
      | Abias Corpus Da Silva      | 111    | 0	| 100   |
      | Antônio Morrendo das Dores | 222    | 0 | 200   |
      | Carabino Tiro Certo        | 333    | 0 | 200   |

  Cenario: Verifica o total de contas criadas
    Dado o calculo do total de contas criadas
    Entao o total de contas e 3

  Cenario: Verifica o total de dinheiro no banco
    Dado o calculo do total de dinheiro
    Entao o total de dinheiro no banco e 500.0