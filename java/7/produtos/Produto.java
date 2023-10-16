package produtos;

public class Produto {
    private String _identificador;
    private String _descricao;
    private int _quantEstoque;
    private double _valorUnidade;
    
    Produto(String identificador, String descricao, int quantEstoque, double valorUnidade){
        this._identificador = identificador;
        this._descricao = descricao;
        this._quantEstoque = quantEstoque;
        this._valorUnidade = valorUnidade;
    }

    public void reporProduto(int quantidade) throws BadQuantity {
        if(quantidade <= 0)
            throw new BadQuantity();
        _quantEstoque += quantidade;
        
    }

    public void darBaixaProduto(int quantidade){
        if(quantidade <= 0)
            throw new BadQuantity();
        _quantEstoque += quantidade;
    }

    //Getters
    public String getId(){
        return _identificador;
    }

    public String getName(){
        return _descricao;
    }

    public int getQuantEstoque(){
        return _quantEstoque;
    }

    public double getValorUnidade(){
        return _valorUnidade;
    }
}
