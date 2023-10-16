package produtos;
import java.time.LocalDate;

public class ProdutoPerecivel extends Produto{
    private LocalDate dataValidade;

    ProdutoPerecivel(String identificador, String descricao, int quantEstoque, LocalDate dataValidade){
        super(identificador, descricao, quantEstoque, quantEstoque);
        this.dataValidade = dataValidade;
    }

    public void reporProduto(int quantidade){
        if(estaVencido())
            throw new ProdutoVencidoException();
        super.darBaixaProduto(quantidade);
    }

    public void darBaixaProduto(int quantidade) {
        if(estaVencido())
            throw new ProdutoVencidoException();
        super.darBaixaProduto(quantidade);   
    }

    public boolean estaVencido(){
        LocalDate hoje = LocalDate.now();
        return dataValidade.isBefore(hoje);
    }

    public static void main(String[] args) {
        
    }
}

