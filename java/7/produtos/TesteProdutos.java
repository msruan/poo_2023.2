package produtos;

import java.time.LocalDate;

public class TesteProdutos {
    public static void main(String[] args) {
        ProdutoPerecivel arroz = new ProdutoPerecivel("a", "branco", 2, LocalDate.of(2023,03,03));
        ProdutoPerecivel feijao = new ProdutoPerecivel("b", "do sul", 3, LocalDate.of(2023,12,03));

        Estoque paoDeAcucar = new Estoque();
        try{
            paoDeAcucar.insertProduct(feijao);
            paoDeAcucar.insertProduct(arroz);
            paoDeAcucar.insertProduct(feijao);
            System.out.println(paoDeAcucar.getProductForID("a") == null);
            System.out.println(paoDeAcucar.getProductForID("b") == null);
        }catch(ProductException e){
            System.out.println(e.getMessage());
        }
        
    }
}
