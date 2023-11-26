package contas_b;

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
        return String.format("\nTotal de contas: %d\nDinheiro total: R$%f\nMédia de dinheiro por conta: R$ %f\n\n",this.consultarTotalDeContas(),this.consultarTotalDeDinheiro(),this.consultarMediaDeDinheiro());
    }

    //Metodos
    public void listarContas(){
        for(Conta conta : contas){
            System.out.println(conta.getNome());
        }
    }
    
    public int consultarTotalDeContas(){
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

    public double consultarTotalDeDinheiro(){
        double saldo_total = 0;
        for(Conta conta: contas){
            saldo_total += conta.getSaldo();
        }return saldo_total;
    }

    public double consultarMediaDeDinheiro(){
        return consultarTotalDeDinheiro() / consultarTotalDeContas();
    }

    public void excluirContaPorNumero(String numero){
        int index = obterIndicePorNumero(numero);
        if(index != -1){
            contas.remove(index);
        }
    }
    public Conta consultarPorNumero(String numero) {
        for (Conta item : this.contas) {
            if (item.getNumero().equals(numero))
                return item;
        }
        return null;
    }
    private int obterIndicePorNumero(String numero){
        for(int i =0; i < contas.size(); i++){
            if(numero.equals(contas.get(i).getNumero()))
                return i;
        }return -1;
    }
    
    //Operacoes basicas
    public void cadastrarConta(Conta conta){
        
        if(!estaCadastrada(conta.getNumero())){
            contas.add(conta);
        }
    }

    public void sacar(String numero, double valor) throws Exception{

        Conta alvo = consultarPorNumero(numero);
        if(alvo != null){
            alvo.sacar(valor);
        }
    }

    public void depositar(String numero, double valor) throws Exception{
        Conta alvo = consultarPorNumero(numero);
        if(alvo != null) 
            alvo.depositar(valor);
    }

    public void transferir(String fonte, String destino, double valor) throws Exception{

        Conta conta_fonte = consultarPorNumero(fonte);
        Conta conta_destino = consultarPorNumero(destino);

        if(conta_fonte != null && conta_destino != null){
            conta_fonte.transferir(conta_destino,valor);
        }
    }

    public void alterar(Conta conta) {

        int indice_procurado = obterIndicePorNumero(conta.getNumero());
        if (indice_procurado != -1)
            contas.set(indice_procurado, conta);
    }

    public void renderJuros(String numero) throws Exception{
        Conta conta = consultarPorNumero(numero);
        if(conta != null){
            ContaPoupanca contaP = (ContaPoupanca)conta;
            contaP.renderJuros();
        }
    }
}