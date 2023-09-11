/*
10. Crie uma classe chamada Jogador e nela:
• Crie 3 atributos inteiros representando força, nível e pontos atuais;
• Crie um construtor no qual os 3 parâmetros são passados e inicialize os
respectivos atributos;
• Crie um método chamado calcularAtaque. Nele, calcule e retorne o valor da
multiplicação de força pelo nível. Esse resultado é o dano de ataque do
jogador;
• Crie um método chamado atacar em que é passado um outro jogador
(atacado) como parâmetro. Nele e é feita a subtração do dano (método
calcularAtaque) dos pontos do atacado;
• Crie um método chamado estaVivo que retorna true caso o atributo pontos
do jogador seja maior que zero e falso caso contrário.
• Altere o método atacar para usar o método está vivo e desconsiderar a
operação, ou seja, não atacar, caso o jogador passado por parâmetro não
esteja vivo.
• Crie um método chamado toString() que retorna a representação textual do
produto concatenando todos os seus atributos.
• Avalie em com testes dois jogadores instanciados e inicializados através do
construtor. Utilize o método de ataque de cada jogador e ao final, verifique
qual jogador tem mais pontos. */
class Jogador{
    forca:number;    
    nivel:number;    
    pontos_atuais:number;
    constructor(f:number,n:number,p:number){
        this.forca = f;
        this.nivel = n;
        this.pontos_atuais = p;
    }    
    estaVivo():boolean{
        return this.pontos_atuais > 0;
    }
    calcularAtaque():number{
        return this.forca * this.nivel;
    }
    Atacar(adv: Jogador){
        if(adv.estaVivo())
            adv.pontos_atuais -= this.calcularAtaque();
    }
    toString(){
        return `\nForça: ${this.forca} \nNível: ${this.nivel} \nPontos atuais: ${this.pontos_atuais}\n`;
    }
}
let j1: Jogador = new Jogador(15,4,100);
let j2: Jogador = new Jogador(10,2,100);
j1.toString()