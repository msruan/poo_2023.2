//4. Considere a classe Radio e as instruções que fazem seu uso abaixo:
//class Radio {
//volume : number;
//constructor(volume : number) {
//this.volume = volume;
//}
//}
//let r : Radio = new Radio();
//r.volume = 10;

//A classe apresenta um construtor declarado, que recebe um atributo do tipo inteiro ao ser iniciaizado, porém o código em questão não passa nenhum valor para o construtor da classe.
//Uma possível solução seria:
//*(em Java)
class Radio{
   private int volume;


   Radio(int volume){
       this.volume = volume;
   }
   void aumentarVol(int quantidade){
       volume += quantidade;
       if(volume > 100)
           volume = 100;
   }
   void diminuirVol(int quantidade){
       volume -= quantidade;
       if(volume < 0)
           volume = 0;
   }
}


class Main{
   public static void main(String[] args){
       Radio radio = new Radio(100);
   }
}
