# API de Gerenciamento de Pessoas

## Descrição

A API de Gerenciamento de Pessoas é uma aplicação que permite realizar operações básicas relacionadas
a informações pessoais. Ela oferece funcionalidades para cadastrar novas pessoas, editar informações 
existentes, excluir registros e pesquisar por todas as pessoas cadastradas ou por um ID específico.

## Funcionalidades Principais

### Cadastro de Pessoas:
Endpoint: POST /persons
Descrição: Permite cadastrar novas pessoas fornecendo informações como nome, idade, endereço, etc.

### Edição de Informações:
Endpoint: PUT /persons/{id}
Descrição: Permite editar as informações de uma pessoa existente com base no ID fornecido.

### Exclusão de Registros:
Endpoint: DELETE /persons/{id}
Descrição: Remove o registro de uma pessoa com base no ID fornecido.

### Consulta de Pessoas:
Endpoint 1: GET /persons
Descrição: Retorna a lista de todas as pessoas cadastradas.
Endpoint 2: GET /persons/{id}
Descrição: Retorna os detalhes de uma pessoa específica com base no ID fornecido.

## Requisições e Respostas
### Cadastro de Pessoas (POST /persons)
#### Requisição:

{
"name": "",
"cpf": "",
"address": "",
"office": ""
}

Resposta (200 ok):

### Edição de Informações (PUT /persons/{id})
#### Requisição:

{
"name": "",
"cpf": "",
"address": "",
"office": ""
}

Resposta (200 ok):

### Exclusão de Registros (DELETE /persons/{id})

### Consulta de Pessoas (GET /person/{id})

Resposta (200 ok):

{
"id": uuid
"name": "name",
"cpf": "cpf",
"address": "address",
"office": "office"
}

### Consulta de Pessoas (GET /persons)

[
{
"id": uuid
"name": "name",
"cpf": "cpf",
"address": "address",
"office": "office"
}
]