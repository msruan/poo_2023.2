const saudacao = (nome:string,pronome:string="Sr") => {console.log(`Oi! Tudo bem ${pronome}. ${nome}?`)};
function Saudacao (nome:string,pronome:string="Sr"){
    console.log(`Olá! Como vai você hoje ${pronome}. ${nome}?`)
};
class Saudacoes{
    nome:string;
    pronome:string;
    constructor(n:string,p:string){
        this.nome = n;
        this.pronome = p;
    }
    ola(){
        console.log(`Oba! Tudo em cima ${this.pronome}. ${this.nome}?`)
    }
    tchau(){
        console.log(`Até logo ${this.pronome}. ${this.nome}!`)
    }
}
let exemplo: Saudacoes = new Saudacoes("Juju","Sra");
exemplo.ola()
exemplo.tchau()
saudacao(exemplo.nome,exemplo.pronome)
Saudacao(exemplo.nome,exemplo.pronome)