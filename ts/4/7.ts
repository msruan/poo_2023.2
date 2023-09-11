
/*7. Crie uma classe chamada Triangulo que:
• Possua 3 atributos inteiros representando os lados;
• Crie um método que retorna true se os lados formarem um triângulo de
acordo com a regra: |b-c| < a < b+c;
• Crie 3 métodos: ehIsoceles(), ehEquilatero() e ehEscaleto() que retorne
verdadeiro caso o triângulo seja um dos tipos relacionados ao nome do
método. Eles devem chamar antes de tudo, o método da questão b. e
retornar false se esse método já retornar false também;
• Instancie classes Triangulo de diferentes lados e seus métodos.*/

function modulo(a:number): number{
   if(a < 0)
       return -1 * a;
   else
       return a;


}


class Triangulo{
   a:number;
   b:number;
   c:number;
   constructor(l1:number,l2:number,l3:number){
       this.a = l1;
       this.b = l2;
       this.c = l3;
   }
   ehTriangulo():boolean{
     return (modulo(this.b-this.c) < this.a)
       && (this.a < this.b + this.c);
   }
   ehIsoceles():boolean{
       if(!this.ehTriangulo())
           return false;
       if (this.ehEquilatero() || this.ehEscaleto())
           return false;
       return true;
   }
   ehEquilatero():boolean{
       if(!this.ehTriangulo())
           return false;
       if (this.a == this.b && this.b == this.c)
           return true;
       return false;
   }
   ehEscaleto():boolean{
       if(!this.ehTriangulo())
           return false;
       if(this.a != this.b && this.b != this.c && this.a != this.c){
           return true;
       }return false;
   }
}
const t1: Triangulo = new Triangulo(1,2,3);
console.log(t1.ehTriangulo(),t1.ehEquilatero(),t1.ehIsoceles(),t1.ehEscaleto());
console.log("PROXIMO");
const t2: Triangulo = new Triangulo(3,3,3);
console.log(t2.ehTriangulo(),t2.ehEquilatero(),t2.ehIsoceles(),t2.ehEscaleto());
console.log("PROXIMO");
const t3: Triangulo = new Triangulo(4,3,5);
console.log(t3.ehTriangulo(),t3.ehEquilatero(),t3.ehIsoceles(),t3.ehEscaleto());
console.log("PROXIMO");
const t4: Triangulo = new Triangulo(11,5,5);
console.log(t4.ehTriangulo(),t4.ehEquilatero(),t4.ehIsoceles(),t4.ehEscaleto());
