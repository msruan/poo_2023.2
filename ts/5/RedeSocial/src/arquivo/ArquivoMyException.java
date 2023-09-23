package arquivo;

public class ArquivoMyException extends Exception{

    @Override
    public String getMessage(){
        return "Erro durante execução de operação de arquivo!";
    }

}

 /*public static void main(String[] args) {
        Exception e =new Exception();
        e.getMessage();
    }*/