class SituacaoFinanceira{
    valorCreditos : number;
    valorDebitos : number;

    saldo() : number{
        return this.valorCreditos - this.valorDebitos;
    }
    constructor(valorCreditos : number,valorDebitos : number){
        this.valorCreditos = valorCreditos;
        this.valorDebitos = valorDebitos;
    }
}
let cliente : SituacaoFinanceira = new SituacaoFinanceira(700,500);
console.log(`O valor atual do saldo é ${cliente.saldo()}!`);
