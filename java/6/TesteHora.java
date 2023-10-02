/*2. Crie uma classe Hora que tenha:
a. Três atributos privados e definidos no construtor chamados hora, minutos e
segundos;
b. Métodos públicos para ler hora, minuto e segundo de forma individual;
c. Um método público para retorne a hora no formato “hh:mm:ss”. */

public class TesteHora {
    public static void main(String[] args) {
        Hora horario = new Hora(3, 54, 7);
        System.out.println(horario.getHorario());
    }
}
class Hora {
    private int _hora;
    private int _minutos;
    private int _segundos;

    Hora(int hora,int minutos,int segundos){
        this._hora = hora;
        this._minutos = minutos;
        this._segundos = segundos;
    }

    public int getHora(){
        return _hora;
    }

    public int getMins(){
        return _minutos;
    }

    public int getSegs(){
        return _segundos;
    }

    public String getHorario(){
        return "%02d:%02d:%02d".formatted(getHora(),getMins(),getSegs());
    }
    public static void main(String[] args) {
        
    }
}