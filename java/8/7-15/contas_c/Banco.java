package contas_c;

import java.util.ArrayList;

import contas_c.utils.ManipuladorArquivos;

public class Banco {

    private String nome;
    private ArrayList <Conta> contas;
   
    public Banco(String nome){
        this.nome = nome;
        contas = new ArrayList<>();
    }

    //Metodos
    public void inserir(Conta conta){

        try {
            consultarConta(conta.getNumero());
        }catch (ContaNotFoundException e){
            contas.add(conta);
        }
    }

    public Conta consultarConta(String numero) throws ContaNotFoundException{

        for (Conta item : this.contas) {
            if (item.getNumero().equals(numero))
                return item;
        }
        throw new ContaNotFoundException();
    }

    private int consultarIndice(String numero) throws ContaNotFoundException{

        for(int i =0; i < contas.size(); i++){
            if(numero.equals(contas.get(i).getNumero()))
                return i;
        }throw new ContaNotFoundException();
    }

    //Operacoes basicas
    public void alterar(Conta conta) throws ContaNotFoundException{

        int indice_procurado = consultarIndice(conta.getNumero());
        contas.set(indice_procurado, conta);
    }

    public void excluir(String numero) throws ContaNotFoundException{

        int index = consultarIndice(numero);
        contas.remove(index);
    }

    public void depositar(String numero, double valor) throws ContaNotFoundException, ValorInvalidoException, SaldoInsuficienteException{

        Conta alvo = consultarConta(numero);
        alvo.depositar(valor);
    }

    public void sacar(String numero, double valor) throws ContaNotFoundException, ValorInvalidoException, SaldoInsuficienteException{

        Conta alvo = consultarConta(numero);
        alvo.sacar(valor);
    }

    public void transferir(String num_fonte, String num_destino, double valor) throws Exception{

        Conta fonte = consultarConta(num_fonte);
        Conta destino = consultarConta(num_destino);
        fonte.transferir(destino, valor);
    }

    public double getTotalDepositado(){

        double saldo_total = 0;
        for(Conta conta: contas){
            saldo_total += conta.getSaldo();
        }return saldo_total;
    }
     
    public int getTotalContas(){
        return contas.size();
    }

    public double getMediaDepositada(){
        return getTotalDepositado() / getTotalContas();
    }
    

    public void renderJuros(String numero) throws ContaNotFoundException, NotPoupancaObject, ValorInvalidoException{

        Conta conta = consultarConta(numero);
        if(conta instanceof ContaPoupanca){
            ContaPoupanca contaP = (ContaPoupanca)conta;
            contaP.renderJuros();
        }else 
            throw new NotPoupancaObject();
    }

    public String getPath(){
        return System.getProperty("user.dir")+"/db/%sContas.txt".formatted(nome);
    }
    
    public void carregarDeArquivo() throws Exception{

        String path = getPath();

        if(ManipuladorArquivos.arquivoExiste(path)){

            ArrayList<String> conteudo = ManipuladorArquivos.lerLinhas(path);

            for(String linha : conteudo){
                
                String []atributos = linha.split(";");
                if(atributos[0].equals("0"))
                    inserir(new Conta(atributos[1], atributos[2], Double.parseDouble(atributos[3])));
                else if(atributos[0].equals("1"))
                    inserir(new ContaPoupanca(atributos[1], atributos[2], Double.parseDouble(atributos[3]),Double.parseDouble(atributos[4])));
                else if(atributos[0].equals("2"))
                    inserir(new ContaImposto(atributos[1], atributos[2], Double.parseDouble(atributos[3]),Double.parseDouble(atributos[4])));
            }
        }
    }

    public void salvarEmArquivo() {

        if(getTotalContas() > 0){

            StringBuilder conteudo = new StringBuilder();

            for(Conta conta : contas ){

                if(conta instanceof ContaImposto){
                    ContaImposto auxiliar = (ContaImposto) conta;
                    conteudo.append("2;"+auxiliar.getNumero()+";"+auxiliar.getNome()+";"+auxiliar.getSaldo()+";"+auxiliar.getTaxa()+";\n");
                }
                else if(conta instanceof ContaPoupanca){
                    ContaPoupanca auxiliar = (ContaPoupanca) conta;
                    conteudo.append("1;"+auxiliar.getNumero()+";"+auxiliar.getNome()+";"+auxiliar.getSaldo()+";"+auxiliar.getTaxa()+";\n");
                }
                else 
                    conteudo.append("0;"+conta.getNumero()+";"+conta.getNome()+";"+conta.getSaldo()+";\n");
            }
            ManipuladorArquivos.escreverEmArquivo(getPath(), conteudo.toString());
        }   
    }
    

    @Override
    public String toString(){
        return String.format("\nTotal de contas: %d\nDinheiro total: R$%f\nMédia de dinheiro por conta: R$ %f\n\n",this.getTotalContas(),this.getTotalDepositado(),this.getMediaDepositada());
    }

    //Getters
    public String getNome(){
        return nome;
    }
}
