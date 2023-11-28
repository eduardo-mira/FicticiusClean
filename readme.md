
# Ficticius Clean

API para realizar cálculo de consumo de combustível de veículos.

## Baixar projeto

```
git clone https://github.com/eduardo-mira/FicticiusClean.git
```

## Executar

Gerar o executável (JAR):

Acessar diretório onde se encontro o arquivo pom.xml e executar o comando abaixo:

- Caso possua o maven instalado em sua máquina:
```
mvn clean package
```
- Usar o maven junto ao projeto:
```
mvnw clean package
```
Para gerar o pacote do projeto sem a necessidade de rodar os testes unitários,
deve-se adicionar o parâmetro no final da linha: **-DskipTests**. Ex:
```
mvn clean package -DskipTests
```

O JAR será criado na pasta /target, dentro do diretório do projeto. Acessá-la e executar a aplicação via linha de comando:
```
java -jar ficticiusclean-1.0.0.jar
```
A aplicação será iniciada utilizando a porta 8080 no endereço:
http://localhost:8080/

Caso deseje iniciar a aplicação em outra porta, no exemplo abaixo a porta 8083, o comando deverá ser:
```
java -jar ficticiusclean-1.0.0.jar --server.port=8083
```

## Documentação Swagger

Para visualizar a documentação Swagger da API , acessar no navegador, a URL http://localhost:8080/swagger-ui/index.html

**Lembrando de ajustar a porta caso alterado no passo anterior.**

## Banco de Dados

Esta API utiliza o banco H2, sendo sua execução realizada em memórioa e quando a aplicação for fechada, o banco será apagado.
Ao iniciar a execução alguns dados de veículos são inseridos automaticamente.
