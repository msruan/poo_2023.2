## Uso

Provavelmente por inexperiência minha, caso o programa seja executado a partir do diretório ___'8'___ ou superior, ocorrem erros, pois aparentemente as classes das diferentes questões conseguem se ver e enfim,
a compilação simplesmente não ocorre. Graças à isso, também optei por dar nome distintos à cada pacote contas (o que não resolveu o problema, serviu mais como uma precaução). Ou seja, é preciso entrar em pasta por pasta para executar o código, como _'3-5'_ ou _'6'_.

## Considerações
Como a classe mãe das exceções de Java é Exception e não Error, usei o sufixo Exception em minhas próprias exceções. Também tomei liberdade de nomeá-las de modo diferente do modelo pedido, mas com nomes com sentido semelhante, acredito que não haverá confusões. Há algumas discrepâncias entre os métodos de entrada de dados, pois na pasta _'3-5'_ você ainda encontra muito o uso de Scanner, mas na _'7-15'_ isso foi quase que completamente substituído pelo JOptionPane, mas de modo algum acredito que isso infrige o que foi pedido. Pequenas mudanças na lógica e estrutura do código estão inclusas, mas peço perdão, pois não tive paciência de refletir as mudanças que fiz no último em todas. 

## Banco De Dados

Devido à necessidade de persistência dos dados em arquivos de texto exigida desde a atividade _7_, acabou-se tendo que utilizar tratamento de exceções nas funções de manipulação de arquivos, já que ao menos em
meu nível de configuração de ambiente, o Java exige obrigatoriamente o tratamento das exceções IOException que podem surgir dos arquivos, a ponto de não compilar sem isso. Para abstrair esses detalhes, optei por deixar essas funções num arquivo à parte no pacote _conta__*.utils_ (o * respresenta uma letra), chamado ___ManipuladorArquivos___.
 
Os dados estão salvos no formato abaixo, separados por ponto e vírgula(;).

#### _CONTA_

| Tipo |    Numero   |  Nome  |   Saldo    | Taxa | 
| :----: | :--------------: | :--------------: | :--------------------: | :--------------------: | 
|   1  | 1234 | João Neto  | 15000 |  0.75  |   
|   2  | 9999 | Marcos Santos    |378 |  0.4  |   
|   0  | 5678 |  Júlia Sousa   | 90 |

_**0 = Normal**_, _**1 = Poupanca**_, _**2 = Imposto**_.
