# job-developer-verx
Desafio de java da Consultoria Verx


V1.:
Premissas:
- Serão avaliadas todas as características da solução apresentada
- Caso não saiba por onde começar, procure algum tutorial de criação de CRUD Rest com Spring Boot
- Caso tenha dificuldades ou não saiba como continuar, entregue até onde conseguir e explique quais problemas teve
- Usamos Java em nossos sistemas
- Considere apenas a parte backend. Não é necessário desenvolver tela/formulário, apenas os endpoints REST
- Um cliente é composto apenas por nome e idade
- API aberta de geolocalização por IP https://www.ipvigilante.com/
- API aberta de clima por geolocalização https://www.metaweather.com/api/
- Quando executar a busca de clima por geolocalização, caso não exista a cidade especifica de origem, utilize o resultado mais próximo.

Sua tarefa é desenvolver os serviços REST abaixo:
- Criar um Cliente
- Alterar um Cliente
- Consultar um Cliente por id
- Listar todos os Clientes salvos
- Remover Cliente por id

Ao criar um cliente, apenas para fins estatísticos e históricos, busque qual a localização geográfica de quem executou a requisição, usando o IP de origem. Com a localização geográfica, consulte qual é a temperatura máxima e mínima do dia da requisição de criação no local do IP de origem. Salve essa informação e a associe ao cliente resultado da requisição de origem.

Tenha em mente que a consulta de Cliente por ID será altamente requisitada.

Junto com o código é necessário entregar uma documentação que contenha os itens abaixo:
- Como usar os serviços
- Quais ferramentas foram usadas (e porque essas foram as escolhidas)
- Qualquer infraestrutura adicional necessária para executar, testar, empacotar e entregar seu projeto
- Como executar, testar, empacotar e entregar o seu projeto
- Instruções para como montar o ambiente de produção onde seus serviços devem ser executados (preferencialmente citando ferramentas e processos)

# O Desafio
Feito utilizando de tecnologias do Java como: Spring MVC / Spring Data / Spring boot.
Também utilizado o banco de dados h2 onde toda a parte de modelagem e estruturação foi feita junto ao repository.
Como ferramente de validação e testes foi utilizado o restlet client, já que o não foi necessário incluir páginas de navegação.

Para o projeto só foi necessário a criação de uma unica aplicação o login-verx

Para utilização e validação do projeto é necessário.
 * **Primeiro passo**:baixe a versão pelo github e o utilize através do eclipse.
 * **Segundo passo**: verificar se após a aplicação funcionando o banco de dados h2 também se iniciou.
 * **Terceiro passo**: para executar os testes utilize o restlet client	para enviar as requisições.

 Inserindo dados   
 <img width="100%" height="100%" alt="Diagram services" src="https://github.com/mmsalmeida/job-developer-verx/blob/master/dados_insert.png">
 Listando dados
  <img width="100%" height="100%" alt="Diagram services" src="https://github.com/mmsalmeida/job-developer-verx/blob/master/dados_lista.png">
 Deletando dados
 <img width="100%" height="100%" alt="Diagram services" src="https://github.com/mmsalmeida/job-developer-verx/blob/master/dados_remove.png">
 Alterando dados
 <img width="100%" height="100%" alt="Diagram services" src="https://github.com/mmsalmeida/job-developer-verx/blob/master/dados_altera.png">
 
 
 # **Considerações finais**
 A única funcionalidade que não foi concluida foi a de integração com os serviços de localização e de tempo passadas no exercício.
 Foi realizado uma consulta externa para descobrir o IP porém, para passá-la ao estágio seguinte de geolocalização alguns problemas foram apresentados.
 Abaixo segue um exemplo de que no código quando passamos o IP exposto ai código conseguimos realizar uma consulta e trazer valores.
 
 <img width="100%" height="100%" alt="Diagram services" src="https://github.com/mmsalmeida/job-developer-verx/blob/master/dados_Insert_sv.png">
 
 
