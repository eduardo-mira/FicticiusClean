
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
O JAR será criado na pasta /target, dentro do diretório do projeto. Acessá-la e executar a aplicação via linha de comando:
```
java -jar ficticiusclean-1.0.0.jar
```
A aplicação será iniciada utilizando a porta 8080 no endereço:
http://localhost:8080/

## Documentação Swagger

Para visualizar a documentação Swagger da API , acessar no navegador, a URL http://localhost:8080/swagger-ui/index.html

## Banco de Dados

Esta API utiliza o banco H2, sendo sua execução realizada em memórioa e quando a aplicação for fechada, o banco será apagado.
Ao iniciar a execução alguns dados de veículos são inseridos automaticamente.
