package contas_c.utils;

import java.util.Scanner;

public class MenuUtils {

    public static String gerarMenu(String titulo, String opcoes) {
        
        StringBuilder menu = new StringBuilder(String.format("*****"+ConsoleColors.CYAN_BOLD+" %s "+ConsoleColors.RESET+"*******\n", titulo));
        String[] arr_opcoes = opcoes.split(",");
        for (int i = 0; i < arr_opcoes.length; i++) {
            //menu.append(String.format("%c%d - %s\n", (i < 10 ? '0' : '\0'), i + 1, arr_opcoes[i].trim()));
            menu.append(String.format("%s%d%s - %s\n",ConsoleColors.CYAN_BOLD, i + 1,ConsoleColors.RESET, arr_opcoes[i].trim()));
        }
        menu.append(ConsoleColors.CYAN_BOLD+"0"+ConsoleColors.RESET+" - Sair\n>>> ");
        return menu.toString();
    }

    public static int lerInt(String label, Scanner input) {
        
        System.out.print(label);
        while (!input.hasNextInt()) {
            System.out.print("Entrada inválida! Por favor, digite um inteiro!\n>>> ");
            input.next();
            input.nextLine();
        }
        return input.nextInt();
    }

    public static void pause(Scanner input, String label){
        System.out.print(label);
        input.nextLine();
    }

    public static boolean ehSim(String resposta){

        return resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S") ||
                resposta.equalsIgnoreCase("yes") || resposta.equalsIgnoreCase("y") ||
                resposta.equalsIgnoreCase("true") || resposta.equalsIgnoreCase("t") ||
                resposta.equalsIgnoreCase("1") || resposta.equalsIgnoreCase("v");
    }

    public static boolean ehNao(String resposta){

        return resposta.equalsIgnoreCase("Nao") || resposta.equalsIgnoreCase("N") ||
                resposta.equalsIgnoreCase("no") || resposta.equalsIgnoreCase("not") ||
                resposta.equalsIgnoreCase("false") || resposta.equalsIgnoreCase("f") ||
                resposta.equalsIgnoreCase("0") || resposta.equalsIgnoreCase("Não");
    }

    public static boolean lerSimOuNao(String pergunta,Scanner input){

        String resposta = lerString(pergunta,input);
        while(!(ehSim(resposta) || ehNao(resposta))){
            System.out.print("Resposta inválida! "+pergunta);
            resposta = input.nextLine();
        }
        return ehSim(resposta);
    }

    public static double lerDouble(String string, Scanner input){

        System.out.print(string);
        double numero = -1;
        while(!input.hasNextDouble()) {
            input.next();
            input.nextLine();
            System.out.println("Entrada invalida, favor digite um número: ");
        }numero = input.nextDouble();
        return numero;
    }

    public static String lerString(String string, Scanner input){

        System.out.print(string);
        String saida = input.nextLine();
        while(saida.isEmpty() || saida.isBlank())
            saida = input.nextLine();
        return saida.trim();
    }

    public static void limparConsole(){

        final String os = System.getProperty("os.name");
        if(os.contains("win")){
            for(int i  = 0; i < 20; i++)
                System.out.println();
            System.out.flush();
        }
        else{
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}