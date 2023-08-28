function array_contem_elemento(colecao: number[],numero: number): boolean{
    for(let i of colecao){
        if (i==numero){
            return true;
        }
    }return false;
}
const eh_primo = (x:number): boolean => {return array_contem_elemento([1,2,3,5,7],x) || ( ( (x%2!=0 && x%3!=0) && (x%5!=0 && x%7!=0) ) );};
function ehPrimo(x:number): boolean{
    return (array_contem_elemento([1,2,3,5,7],x) || ((x%2!=0) && (x%3!=0) && (x%5!=0 && x%7!=0)) );
};

class Primo{
    x:number;
    constructor(x: number){
        this.x = x;
    }eh_primo(){
        console.log( ( array_contem_elemento([1,2,3,5,7],this.x) || ((this.x %2!=0) && (this.x %3!=0) && (this.x %5!=0 && this.x %7!=0)) ) ? "É primo!!!":"Não é primo!");
    }
};
let a : Primo = new Primo(2);
a.eh_primo();
console.log(ehPrimo(a.x));
console.log(eh_primo(5));
console.log(eh_primo(3))
console.log(eh_primo(7))
console.log(eh_primo(197))
console.log(eh_primo(13))
console.log(eh_primo(15))