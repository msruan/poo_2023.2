class Circulo{
    raio : number = 0;

    calcularComprimento(){//c = 2.pi.r
        console.log(`O valor do comprimento é ${(2 * Math.PI * this.raio).toFixed(2)} cm`);
    }
    calcularArea(){//a = pi.r²
        console.log(`O valor do área é ${(Math.PI * Math.pow(this.raio,2)).toFixed(2)} cm`) ;
    }
    constructor(raio : number){
        this.raio = raio;
    }
}
let circulo1 : Circulo = new Circulo(3);
circulo1.calcularArea();
circulo1.calcularComprimento();
