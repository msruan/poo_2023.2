package contas_c;


import java.util.ArrayList;

public class Banco {

    private String nome;
    private ArrayList <Conta> contas = new ArrayList<>();
   
    public Banco(String nome){
        this.nome = nome;
    }

    //Getters
    public String getNome(){
        return nome;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    @Override
    public String toString(){
        return String.format("\nTotal de contas: %d\nDinheiro total: R$%f\nMédia de dinheiro por conta: R$ %f\n\n",this.obterTotalDeContas(),this.obterTotalDeDinheiro(),this.obterMediaDeDinheiro());
    }

    //Metodos
    public void listarContas(){
        for(Conta conta : contas){
            System.out.println(conta.getNome());
        }
    }
    
    public int obterTotalDeContas(){
        return contas.size();
    }

    public boolean estaCadastrada(String numero){
        for(Conta conta: contas){
            if(conta.getNumero().equals(numero))
                return true;
        }return false;
    }

    public boolean temContas(){
        return !contas.isEmpty();
    }

    public double obterTotalDeDinheiro(){
        double saldo_total = 0;
        for(Conta conta: contas){
            saldo_total += conta.getSaldo();
        }return saldo_total;
    }

    public double obterMediaDeDinheiro(){
        return obterTotalDeDinheiro() / obterTotalDeContas();
    }

    public void excluirContaPorNumero(String numero) throws AccountNotFoundException{

        int index = consultarIndicePorNumero(numero);
        contas.remove(index);
    }

    public Conta consultarContaPorNumero(String numero) throws AccountNotFoundException{

        for (Conta item : this.contas) {
            if (item.equals(numero))
                return item;
        }
        throw new AccountNotFoundException();
    }

    private int consultarIndicePorNumero(String numero) throws AccountNotFoundException{

        for(int i =0; i < contas.size(); i++){
            if(contas.get(i).equals(numero))
                return i;
        }throw new AccountNotFoundException();
    }
    
    //Operacoes basicas
    public void cadastrarConta(Conta conta){
        
        if(!estaCadastrada(conta.getNumero())){
            contas.add(conta);
        }
    }

    public void sacar(String numero, double valor) throws Exception{

        Conta alvo = consultarContaPorNumero(numero);
        alvo.sacar(valor);
    }

    public boolean depositar(String numero, double valor) throws Exception{

        Conta alvo = consultarContaPorNumero(numero);
        return alvo.depositar(valor);
    }

    public boolean transferir(String num_fonte, String num_destino, double valor) throws AccountNotFoundException, Exception{

        Conta fonte = consultarContaPorNumero(num_fonte);
        Conta destino = consultarContaPorNumero(num_destino);
        return fonte.transferir(destino, valor);
    }

    public void alterar(Conta conta) throws AccountNotFoundException{

        int indice_procurado = consultarIndicePorNumero(conta.getNumero());
        contas.set(indice_procurado, conta);
    }

    public void renderJuros(String numero) throws AccountNotFoundException, Exception{
        
        Conta conta = consultarContaPorNumero(numero);
        if(conta instanceof ContaPoupanca){
            ContaPoupanca contaP = (ContaPoupanca)conta;
            contaP.renderJuros();
        }
    }
}