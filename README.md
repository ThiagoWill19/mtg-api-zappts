# mtg-api-zappts

### http://localhost:8080

###  Documentação com SWAGGER -> http://localhost:8080/swagger-ui.html

API para criar listas de card de Magic (MTG).


## Users

 ### Post
 host/users
 * Cadastra usuário
 * Body:
 ``` json
 {
    "name" : "Thiago"
 }
 ```
## Lists

 ### Post
 host/lists
 * Cria uma nova lista (deve ter um usuário já cadastrado)
 * body:
 ``` json
 {
    "listName" : "My cards",
    "userId" : 1
 }
 ```
 host/lists/add
 * Cria um card e adiciona em uma lista
 * Opções de linguagem: pt-br, en, jp.
 * body:
 ```json
  {
    "listId": 0,
    "userId": 0,
    "card": {
      "name": "string",
      "edition": "string",
      "language": "string",
      "foil": true,
      "price": 0,
      "quantity": 0
     }
  }
 ```
 host/lists/update
 * Altera um card em uma lista
 * body:
 ```json
 {
  "newPrice": 25,
  "newQuantity": 1,
  "listId": 2,
  "userId": 1,
  "cardId": 2
}
 ```
 host/lists/remove
 * remover um card de uma lista
 * body:
 ```json
 {
  "cardId": 0,
  "userId": 0,
  "listId": 0
 }
 ```
 ### Get
 host/lists
 * Mostra todas as listas de cards
 
 host/lists/{listname}
 * Retorna uma lista com o nome passado
 

