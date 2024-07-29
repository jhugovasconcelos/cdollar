# cdollar - API de consulta de cotações do dólar
---
Esta API irá consultar a cotação do dólar PTAX do dia e calcular o valor que será cobrado de acordo com o banco, fazendo a soma do spread e do IOF. 
A princípio, está incluso apenas o Nubank. Futuramente serão incluídos outros bancos que operam com cartão de crédito internacional.

## Rotas
Para fazer uma consulta simples do valor do dólar: `/price` <br>
Para consultar apenas o valor do dólar com o spread: `/spread/{nome-do-banco}` <br>
Para consultar o valor do dólar com spread e iof: `/rates/{nome-do-banco}`

## Design Patterns
Esta API utiliza os padrões Facade (ao criar uma 'fachada' para a consulta do dólar PTAX do bacen) e
Strategy (ao criar uma interface que pode ser implementada de acordo com o banco, possibilitando incrementos futuros). Além disso, o padrão Singleton é amplamente utilizado com os 
beans do Spring. 
