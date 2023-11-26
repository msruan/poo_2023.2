## Uso

Provavelmente por inexperiência minha, caso o programa seja executado a partir do diretório ___'8'___ ou superior, ocorrem erros, pois aparentemente as classes das diferentes questões conseguem se ver e enfim,
a compilação simplesmente não ocorre. Graças à isso, também optei por dar nome distintos à cada pacote contas (o que não resolveu o problema, serviu mais como uma precaução). Ou seja, é preciso entrar em pasta por pasta para executar o código, como _'3-5'_ ou _'6'_.

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
