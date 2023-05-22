# crudJDBC
JDBC
---
JDBC (Java Database Connectivity) é um conjunto de classes e interfaces escritas em Java que fazem o envio de instruções SQL para qualquer banco de dados relacional. Para cada banco de dados, há um driver JDBC.


Classes da API jdbc
-------
- Statement,  um objeto que executa uma declaração sql e retorna o resukltado do produto
    - Instanciar o objeto do tipo statement
    - Executar a query
- ResultSet, Um objeto que mantém um cursor apontando para sua linha atual de dados.
    - Obter dados
    - first() > posição 1 se houver
    - beforeFirst() > posição 0
    - next()> próximo. false se estiver no último
        - enquanto existir o próximo
    - absolut(int)> posição indicada com número inteiro.
- PrepareStatement um objeto que pre-compila uma declação sql
- executeUpdate

### Tipos de Dados em Java X Memória consumida

| CRUD Operation | HTTP Request Method | SQL
|----------------|---------------------|-----
| Create         | POST                |INSERT
| Read           | GET                 |SELECT
| Update         | PUT or PATCH        |UPDATE
| Delete         | DELETE              |DELETE

## Formatação de arquivo .md

- `src`: the folder to maintain sources
  [here](https://github.com/deisekinsk/condicionalJava).
> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.