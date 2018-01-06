# dm110
Trabalho de conclusão Desenvolvimento JavaEE - DM110 - PÓS-GRADUAÇÃO EM DESENVOLVIMENTO DE APLICAÇÕES PARA DISPOSITIVOS MÓVEIS E CLOUD COMPUTING

## Detalhes da aplicação:
*Datasource:
  * Nome:poller
  * JNDI:java:/PollerDS
*Fila:
  * Nome:DM110_Poller_Queue
  * JNDI:java:/jms/queue/dm110pollerqueue

## Detalhes da interface REST:

### Comando de início de varredura:

* URL: /api/poller/start/{IP}/{Mask}
* Método: GET
* Funcionamento:
  * Calcula todos os endereços da rede (desconsiderando o endereço de rede e de broadcast).
  * Cria mensagens JMS sendo que cada mensagem deverá conter uma lista de no máximo 10 endereços IP.
  * Insere mensagens na fila.
  * Deverá existir um MDB consumindo mensagens desta fila e fazendo a verificação do status do equipamento referente ao endereço IP.
  * Para cada endereço verificado, deverá salvar uma linha em uma tabela na base de dados contendo, pelo menos, o endereço IP verificado e o status (Ativo ou Inativo).

### Verificação do status do equipamento:

* URL: /api/poller/status/{IP}
* Método: GET
* Funcionamento: Busca o equipamento na base de dados e retorna o status.

Baseado na descrição do exercício em:
https://github.com/inatel/2017-dm110-2/blob/master/exercicios/projetoFinal.md