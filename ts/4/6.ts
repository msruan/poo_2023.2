/*6. Crie uma classe chamada Saudacao que:
• Contenha um atributo chamado texto e outro chamado destinatario, ambos
String;
• Crie um construtor que inicializa os dois atributos;
• Crie um método obterSaudacao() que retorne a concatenação dos dois
atributos. Ex: "Bom dia, João";
• Instancie uma classe Saudacao e teste seu método obterSaudacao().*/
class Saudacao{
   texto:string;
   destinatario:string;
   constructor(t:string,d:string){
       this.texto = t;
       this.destinatario = d;
   }
   obterSaudacao(): string{
       return this.texto + this.destinatario;
   }
}
let eli:Saudacao = new Saudacao("Olá, como vai ","Eli");
console.log(eli.obterSaudacao()+"?");