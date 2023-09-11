//3. Ainda sobre a classe do exemplo anterior, considere o código abaixo:
//let hotel : Hotel = new Hotel(2);
//console.log(hotel.quantReservas);
//Adicione o construtor que aceite um parâmetro inteiro e faça a inicialização do atributo
//quantReservas.
 
//*Adicionando o constructor:
//!Em java:
class Hotel {
    int reservas;
    Hotel(int reservas){
        this.reservas = reservas;
    }
    void adicionarReserva(){
        this.reservas++;
    }
}

