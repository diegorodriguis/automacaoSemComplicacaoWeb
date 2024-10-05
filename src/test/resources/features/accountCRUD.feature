#language:pt

Funcionalidade: Account CRUD

  @cadastroConta
  Cenario: Cadastro nova conta
    Dado que a pagina new account esteja sendo exibida
    Quando os campos de cadastros estiverem preenchidos com
      | username | chronosDiego           |
      | email    | chronosdiego@gmail.com |
      | password | Senha123               |
      | country  | Brazil                 |
    Entao deve ser possivel logar no sistema apos o cadastro

  @loginCRUD
  Cenario: Realizar login crud
    Dado que a modal esteja sendo exibida
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | chronosDiego |
      | password | Senha123     |
      | remember | faslse       |
    Quando for realizado o clique no botao sign in
    Entao deve ser logado no sistema


  @editarCRUD
  Cenario: Realizar edicao conta crud
    Dado que esteja logado no sistema com
      | login    | chronosDiego |
      | password | Senha123     |
      | remember | faslse       |
