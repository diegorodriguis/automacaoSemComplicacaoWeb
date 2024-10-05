#language:pt

@login
Funcionalidade: Login
  Testar funcionalidade de login por completo

  Contexto: Deve clicar no icone para exibir a modal
    Dado que a modal esteja sendo exibida

  @fecharModal
  Cenario: Fechar a modal fora dela
    Quando for realizado um clique fora da modal
    Entao a modal deve ser fechada

  @fecharModalIcone
  Cenario: Fechar a modal clicando no ícone
    Quando for realizado um clique no icone
    Entao a modal deve ser fechada

  @CreateAccount
  Cenario: Link create new account
    Quando for realizado um clique no link Create new account
    Entao deve ser direcionado para tela de criacao de conta

  @loginComSucesso
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao deve ser logado no sistema

    Exemplos:
      | identificacao       | login     | password | remember |
      | campos obrigatorios | lokocrazy | Lc123456 | false    |
      | todos os campos     | lokocrazy | Lc123456 | true     |

  @loginDadosInvalidos
  Esquema do Cenario:  Realizar login com <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao sistema deve exibir uma mensagem de erro

    Exemplos:
      | identificacao  | login     | password | remember |
      | login invalido | invalido  | Lc123456 | false    |
      | senha invalida | lokocrazy | invalida | true     |

  @dadosEmBranco
  Esquema do Cenario:  Realizar login com <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Entao o botao sign in deve ficar desabilitado

    Exemplos:
      | identificacao     | login   | password | remember |
      | usuario em branco |         | senha    | false    |
      | senha em branco   | chronos |          | true     |