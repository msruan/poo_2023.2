package arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ManipuladorArquivos {
    public static void main(String[] args) {
        gravarArquivo("teste.txt","só alegria haha");
        System.out.println(lerArquivo("teste.txt"));
    }
    public static String lerArquivo(String caminho){
        StringBuilder conteudo = new StringBuilder();
        BufferedReader leitor;
        try {
            leitor = new BufferedReader(new FileReader(caminho));
            try{
                String linha = leitor.readLine();
                for(; linha != null; linha = leitor.readLine())
                    conteudo.append(linha);
                leitor.close();
            }catch(IOException e){
                System.out.println("Problema durante leitura do arquivo!");
            }
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado!");
        }
        return conteudo.toString();
    }
    public static boolean gravarArquivo(String caminho, String texto){
        try {
            BufferedWriter gravador = new BufferedWriter(new FileWriter(caminho,true));
            gravador.write(texto+'\n');
            if(texto.charAt(texto.length()-1) == '\n')
                gravador.newLine();

            gravador.close();
        }
        catch (IOException e){
            System.out.println("Erro durante gravação de arquivo!");
            return false;
        }return true;

    }
}
