
//const readline = require('readline-sync') 
//import {question} from 'readline-sync'
const eh_par = (numero: number): boolean => {return numero%2==0};


function ehPar(numero : number):boolean{
    return numero%2==0;
}

class Par{
    static eh_par(numero: number): boolean{
        return numero%2==0;
    }
    static eh_impar(numero: number): boolean{
        return Boolean(numero%2);
    }
    static mostrar_paridade(numero: number){
        if (this.eh_impar(numero))
            console.log("É ímpar...")
        else  
            console.log("É par...")
    }
}