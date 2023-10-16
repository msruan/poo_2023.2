package produtos;


abstract public class ProductException extends RuntimeException {
}

class ProdutoVencidoException extends ProductException {
    @Override
    public String getMessage() {
        return "Cadastro proibido, o produto já está vencido!";
    }
}

class ProductNotFoundException extends ProductException {
    @Override
    public String getMessage() {
        return "Can't find this product!";
    }
    
}

class BadQuantity extends ProductException {
    @Override
    public String getMessage() {
        return "Select a positive quantity of this product!";
    }
}

class ProductAlreadyExists extends ProductException {
    @Override
    public String getMessage() {
        return "Product already registered in this inventory!";
    }
}