# ![DevSuperior logo](https://raw.githubusercontent.com/devsuperior/bds-assets/main/ds/devsuperior-logo-small.png) Spring Boot 2.4.x | [DevSuperior](https://devsuperior.com.br "DevSuperior")
<br>

## About the project ☕

CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas
aprendidas no capítulo:

- Busca paginada de recursos
- Busca de recurso por id
- Inserir novo recurso
- Atualizar recurso
- Deletar recurso

## Diagram class and attributes 📈

<p align="left">
 <img width="25%" height="35%" src="https://imgur.com/DAQhOoF.png">
</p>

## Technologies 🛠️

- Java
- Spring Boot
- Maven
- H2
- JPA / Hibernate

## Customer page search

- GET /clients?page=0&linesPerPage=6&direction=ASC&orderBy=name

## Customer search by id

- GET /clients/1

## Insertion of new customer

- POST /clients

```bash
{ 
    "name": "Moreira Rafael",
    "cpf": "49322222022",
    "income": 7500.0,
    "birthDate": "2022-01-20T10:30:00Z",
    "children": 2 
}
```
## Client update

- PUT /clients/1

```bash
{ 
    "name": "Moreira Rafael",
    "cpf": "22225678922",
    "income": 7500.0,
    "birthDate": "2022-01-20T10:30:00Z",
    "children": 2 
}
```
## Delete customer

- DELETE /clients/1

## [![PyPI license](https://img.shields.io/pypi/l/ansicolortags.svg)](https://github.com/RafaeltiMoreira/spring-boot-2.4.x/blob/main/LICENSE)

## Made with ❤︎ by Rafael Moreira 🚀
