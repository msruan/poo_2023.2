package contas_b.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Files;

public class ManipuladorArquivos {
    
    public static boolean arquivoExiste(String path){
        return Files.exists(Paths.get(path));
    }

    public static ArrayList <String> lerLinhas(String caminho){
        
        ArrayList<String> linhas = new ArrayList<>();
        try{
            Files.lines(Paths.get(caminho)).forEach(line -> linhas.add(line));
        }catch(IOException e){
            System.out.println(String.format("Erro IO durante a leitura do arquivo em %s! ",caminho)+e.getMessage());
        }catch(RuntimeException e){
            System.out.println(String.format("Erro Runtime durante operacao no arquivo em %s! ",caminho)+e.getMessage());
        }return linhas;
    }

    public static void escreverEmArquivo(String caminho, String conteudo){
        try ( BufferedWriter buffwriter = new BufferedWriter(
                new FileWriter(caminho) 
                ) ) {
                    buffwriter.write(conteudo);

        } catch (IOException e){
            System.out.println(String.format("Erro IO durante a tentativa de salvar conteúdo em %s! ",caminho)+e.getMessage());
            e.printStackTrace();
        }catch(RuntimeException e){
            System.out.println(String.format("Erro Runtime durante a tentativa de salvar conteúdo em %s! ",e.getMessage()));
        }
    }
}