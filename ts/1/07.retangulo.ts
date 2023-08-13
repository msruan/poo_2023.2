class TestaRetangulo{
    static exibirPerimetro(retangulo : Retangulo) : void{
        console.log(`O perímetro do retângulo é ${retangulo.calcularPerimetro()}`);
    }
}

class Retangulo {
    l1: number;
    l2: number;
    calcularArea(): number {
        return this.l1 * this.l2;
    }
    calcularPerimetro() : number{
        return this.l1 * 2 + this.l2 * 2;
    } 
    constructor(base : number = 0, altura : number = 0){
        this.l1 = base;
        this.l2 = altura;
    }
}
const retangulo = new Retangulo(2,4);
TestaRetangulo.exibirPerimetro(retangulo);

