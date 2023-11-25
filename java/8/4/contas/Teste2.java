package contas;
public class Teste2 {
    public static void main(String[] args)throws Exception {

        ContaImposto conta = new ContaImposto("123", "João",100,0.6);
        ContaPoupanca conta2 = new ContaPoupanca("456", "Flavia",0,0.48);
       
        conta.transferir(conta2, 200);
    }
    
}
/*  
 * Como no método transferir o método 'sacar' está sendo chamado pela conta debitante, o resultado é que ao
 * passarmos um valor superior ao saldo, é lançada uma exceção dentro do método sacar e esta não é tratada, o que
 * por consequência faz com que a exceção alcance o trecho de código onde o método transferir foi chamado, e como 
 * nesse caso, novamente não a tratamos, a a execução do programa é abortada.
 */