package social;
import java.util.ArrayList;
public class RedeSocial {
        public ArrayList<social.Postagem> postagens;
        public void postar(social.Postagem post){
            postagens.add(post);
        }
        public int getIndexPorId(int id){
            for(int i = 0; i < postagens.size(); i++){
                if(id == postagens.get(i).getId())
                    return i;
            }return -1;//excecao id out of postagens
        }
        public void excluir(int id){
            int index = getIndexPorId(id);
            if(index != -1)
                postagens.remove(index);//outra opcao é levantar uma exceçao aqui
        }
        public Postagem maisCurtida(){
            if(postagens.isEmpty())
                return null;
            social.Postagem acc = postagens.get(0);
            for(social.Postagem post : postagens){
                if(post.getCurtidas() >= acc.getCurtidas())
                    acc = post;
            }return acc;
        }
        public void curtir(int id){
            int index = getIndexPorId(id);
            if(index != -1)
                postagens.get(index).curtir();
        }
        @Override
        public String toString(){
            StringBuilder saida = new StringBuilder();
            for(social.Postagem post: postagens){
                saida.append(post);
            }return saida.toString();
        }






}
