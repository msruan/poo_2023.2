package contas;

import static contas.utils.ManipuladorArquivos.lerLinhas;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class Usuario {
    private UUID id;
    private String cpf;
    private String nome;
    private String senha;
    Usuario(String nome, String cpf, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public UUID getId(){
        return id;
    }

    public static boolean userEstaCadastrado(String cpf){
        Path diretorioPath = Paths.get(System.getProperty("user.dir"),"contas/db");
        if(Files.isDirectory(diretorioPath)){
            Path filePath = diretorioPath.resolve("CadastroUsersDB.txt");
            if(Files.exists(filePath)){
                var conteudo = lerLinhas(filePath);
                for(String linha : conteudo){
                    String []conta = linha.split(";");
                    if(conta[0] == cpf){
                        return true;
                    }
                    
                }
            }
        }return false;
    }

}
