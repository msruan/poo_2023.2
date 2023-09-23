package social;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
public class Postagem {
    public int id;
    public String texto;
    public int curtidas;
    public void curtir(){
        this.curtidas++;
    }
    public int getId(){
            return this.id;
    }
    public int getCurtidas(){
        return this.curtidas;
    }
    @Override
    public String toString(){
        return id+'\n'+texto+'\n'+curtidas+" curtidas\n\n";
    }

}


