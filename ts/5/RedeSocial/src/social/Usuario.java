package social;
import arquivo.ManipuladorArquivos;
import arquivo.ManipuladorArquivos.*;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String user;
    String senha;
    int id;
    Usuario(String user, String senha, int id){
        this.user = user;
        this.senha = senha;
        this.id = id;
        ManipuladorArquivos.lerArquivo("usuarios");
    }public static boolean cadastrarUsuario(String user, String senha, int id){

    }public static boolean estaCadastrado(int id) throws Exception {
        String conteudo = ManipuladorArquivos.lerArquivo("usuarios_bd");
        if(conteudo.isEmpty())
            throw (new Exception());
        String[] linhas = conteudo.trim().split("\n");
        if(id <= Integer.parseInt(linhas[0]) && Integer.parseInt(linhas[0]) > 0){
            return false;
        }
    }

}
