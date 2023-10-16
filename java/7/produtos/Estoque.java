package produtos;
import java.util.ArrayList;
public class Estoque {
    private ArrayList<Produto> produtos;

    Estoque(){
        produtos = new ArrayList<Produto>();
    }

    public void insertProduct(Produto produto) throws ProductAlreadyExists, ProdutoVencidoException{
        try{
            getProductForName(produto.getName());
            throw new ProductAlreadyExists();
        }
        catch(ProductNotFoundException e){  
            if(produto instanceof ProdutoPerecivel){
                ProdutoPerecivel produtoP = (ProdutoPerecivel) produto;
                if(produtoP.estaVencido())
                    throw new ProdutoVencidoException(); 
            }this.produtos.add(produto);
        }
        
    }

    public Produto getProductForName(String name) throws ProductNotFoundException {
        for(Produto produto : produtos){
            if(produto.getName() == name)
                return produto;
        }throw new ProductNotFoundException();
    }  

    public Produto getProductForID(String id) throws ProductNotFoundException {
        for(Produto produto : produtos){
            if(produto.getId() == id)
                return produto;
        }throw new ProductNotFoundException();
    }   

    public void excludeProductForID(String id) throws ProductNotFoundException {
        for(Produto produto : produtos){
            if(produto.getId() == id){
                produtos.remove(produto);
            }
        }throw new ProductNotFoundException();
    }   

    public void reporProduto(String id, int quantidade) throws ProductNotFoundException, ProdutoVencidoException{
        getProductForID(id).reporProduto(quantidade);
    } 

    public void darBaixaProduto(String id, int quantidade) throws ProductNotFoundException, ProdutoVencidoException{
        getProductForID(id).darBaixaProduto(quantidade);
    } 

    public ArrayList<String> getIdVencidos() {
        ArrayList <String> idVencidos = new ArrayList<>();
        for(Produto produto : produtos){
            if(produto instanceof ProdutoPerecivel){
                ProdutoPerecivel produtoV = (ProdutoPerecivel) produto;
                if(produtoV.estaVencido())
                    idVencidos.add(produtoV.getId());
            }
        }return idVencidos;
    }
}
