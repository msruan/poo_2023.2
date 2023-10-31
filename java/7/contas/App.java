package contas;
//import static contas.utils.ManipuladorArquivos.*;
import static contas.utils.MenuUtils.*;
//obs: depositar ta com uma mensagem de saque
//consertar o ler double
//retirar alguns loops desnecssarios, como em consultar

import javax.swing.JOptionPane;
/*import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption
*/
import java.util.Scanner;

public class App {
    public static final int SAIDA = 0;
    public static final int CADASTRO = 1;
    public static final int CONSULTA = 2;
    public static final int SAQUE = 3;
    public static final int DEPOSITO = 4;

    public static final int TRANSFERENCIA = 5;
    public static final int RENDER_JUROS = 6;
    public static final int EXCLUSAO = 7;
    public static final int TOTAL = 8;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do seu banco: ");
        String nome_banco = input.nextLine().trim();
        limparConsole();
        Banco banco = new Banco(nome_banco);
        /*if(arquivoExiste("%sContasDB.txt".formatted(nome_banco))){
            var conteudo = lerArquivo("%sContasDB.txt".formatted(nome_banco)).split("\n");
            for(String linha : conteudo){
                System.out.println(conteudo.length);
                String []conta = linha.split(";");
                banco.cadastrarConta(new Conta(conta[0], conta[1], Double.valueOf(conta[2].replace(",", "."))));
            }
        }*/
        /*Path diretorioPath = Paths.get(System.getProperty("user.dir"),"contas/db");
        if(Files.isDirectory(diretorioPath)){
            Path filePath = diretorioPath.resolve("%sContasDB.txt".formatted(nome_banco));
            if(Files.exists(filePath)){

                var conteudo = lerLinhas(filePath);

                for(String linha : conteudo){
                    System.out.println(conteudo.size());
                    String []conta = linha.split(";");
                    banco.cadastrarConta(new Conta(conta[0], conta[1], Double.valueOf(conta[2].replace(",", "."))));
                }
            }
        }*/
        String menu_principal = gerarMenu(nome_banco,"Cadastrar, Consultar saldo, Sacar, Depositar, Transferir, Render Juros, Excluir, Totalizações");
        int opcao;
        do{
            if(!banco.temContas()) {
                opcao = obterOpcao(gerarMenu(nome_banco, "Cadastrar"));
                if (opcao != 0 && opcao != 1)
                    continue;
            }
            else{
                opcao = obterOpcao(menu_principal);
                if (opcao < 0 || opcao > 7)
                    continue;
            }
            switch (opcao) {
                case CADASTRO:
                    String nome;
                    double saldo;
                    String[] opcoes = { "Normal", "Poupança", "Imposto" };
                    int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                    String numero_cadastro = lerString("\nDigite o número da conta desejada: ", input);
                    while (!(banco.consultarPorNumero(numero_cadastro) == null)) {
                        numero_cadastro = lerString("Este número já está cadastrado!\nPor favor, digite outro: ", input);
                    }
                    nome = lerString("Digite seu nome: ", input);
                    saldo = lerDoublePositivo("\nDigite seu saldo atual: ", input);

                    if(escolha == 1 || escolha == 2){

                        double taxa = lerDoublePositivo("Digite o valor da taxa: ",input);

                        if(escolha == 1)
                            banco.cadastrarConta(new ContaPoupanca(numero_cadastro, nome, saldo, taxa));
                        else
                            banco.cadastrarConta(new ContaImposto(numero_cadastro, nome, saldo, taxa));

                    }
                    else
                        banco.cadastrarConta(new Conta(numero_cadastro, nome, saldo));
                    break;
                case CONSULTA:
                    Conta procurada;
                    do {
                        procurada = banco.consultarPorNumero(lerString("Digite o numero da conta desejada: ", input));
                        if (procurada == null)
                            System.out.println("Conta não encontrada!");
                        else
                            System.out.println(procurada);
                        System.out.println();
                    }while (lerSimOuNao("Deseja realizar uma nova consulta?", input));
                    break;

                case SAQUE:
                    String numero_sacada;
                    double valor_saque;
                    do {
                        numero_sacada = lerString("\nDigite o número da sua conta: ",input);
                        if(banco.estaCadastrada(numero_sacada)){
                            valor_saque = lerDoublePositivo("\nDigite o valor do saque: ",input);
                            if(banco.sacar(numero_sacada,valor_saque)){
                                System.out.println("Saque de R$ "+valor_saque+" realizado com sucesso!");
                                break;
                            }
                            else
                                System.out.println("Saldo insuficiente! ");
                        }else
                            System.out.println("Conta não encontrada!");
                        System.out.println();
                    }while(lerSimOuNao("Repetir operação? ",input));//Limpar tela quando quiser repteir operação...
                    break;

                case DEPOSITO:
                    String numero_depositada;
                    do {
                        numero_depositada = lerString("\nDigite o número da sua conta: ",input);
                        if(banco.estaCadastrada(numero_depositada)){
                            double valor_deposito = lerDoublePositivo("\nDigite o valor do saque: ",input);
                            if(banco.depositar(numero_depositada,valor_deposito)){
                                System.out.println("Depósito de R$ "+valor_deposito+" realizado com sucesso!");
                                break;
                            }
                            else
                                System.out.println("Depósito falhou!");
                        }else
                            System.out.println("Conta não encontrada!");
                        System.out.println();
                    }while(lerSimOuNao("Repetir operação? ",input));
                    break;
                case TRANSFERENCIA:
                    String numero_fonte, numero_destino;
                    double valor_transferencia;
                    do {
                        numero_fonte = lerString("Digite o número da conta fonte: ", input);
                        numero_destino = lerString("Digite o número da conta destino: ", input);
                        valor_transferencia = lerDoublePositivo("Digite o valor a ser transferido: ", input);

                        if (!banco.transferir(numero_fonte, numero_destino, valor_transferencia)) {
                            System.out.println("Operação falhou!");
                        } else {
                            System.out.printf("Transferência de R$ %f para %s realizada com sucesso!", valor_transferencia, banco.consultarPorNumero(numero_destino).consultarNome());
                            break;
                        }
                    }while(lerSimOuNao("Repetir operação? ",input));
                    break;
                case RENDER_JUROS:
                    System.out.print("Digite o número da sua conta poupança:\n>>> ");
                    Conta conta_poupanca = banco.consultarPorNumero(input.nextLine());
                    if(conta_poupanca == null) {
                        System.out.println("\nConta não encontrada!");
                    }
                    else if(conta_poupanca instanceof ContaPoupanca){
                        ((ContaPoupanca)conta_poupanca).renderJuros();
                    }else {
                        System.out.println("Operacao invalida! Verifique se a conta realmente é do tipo poupanca.");
                    }
                    break;
                case EXCLUSAO:
                    Conta alvo;
                    do{
                        alvo = banco.consultarPorNumero(lerString("Digite o numero da conta desejada: ",input));
                        if(alvo == null){
                            System.out.println("Conta não encontrada!");
                        }else{
                            banco.excluirContaPorNumero(alvo.consultarNumero());
                            System.out.println("Exclusão concluída com sucesso!");
                            break;
                        }
                    }while(lerSimOuNao("Deseja tentar novamente?",input));
                    break;
                case TOTAL:
                    System.out.println(banco);
                    break;
                
            }
            limparConsole();
        }while(opcao != SAIDA);
        
        /*if(banco.temContas()){
            StringBuilder contasB = new StringBuilder();
            for(Conta conta : banco.getContas())
                contasB.append(String.format("%s;%s;%f\n", conta.consultarNumero(),conta.consultarNome(),conta.getSaldo()) );
            String contas = contasB.toString();
                //gravarArquivo("%sContasDB.txt".formatted(banco.getNome()), contas.toString());
            if(!Files.exists(diretorioPath)){
                try{
                    Files.createDirectories(diretorioPath);
                }catch(IOException e){
                    System.out.println("Erro durante criacao do diretorio db!" + e.getMessage());
                }
            }
            Path filePath = diretorioPath.resolve("%sContasDB.txt".formatted(nome_banco));
            try{Files.write(filePath, contas.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);}
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }*/
        input.close();
    }
}