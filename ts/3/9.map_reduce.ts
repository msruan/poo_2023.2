function mostrar_vetor(vetor:any[]){
    process.stdout.write("[ ")
    for(let i = 0; i<vetor.length; i++){
        process.stdout.write(`| ${vetor[i]} `);
    };
    console.log("| ]")
}
function mapear(colecao:number[],funcao_transformadora:Function)  {
    for(let i = 0; i<colecao.length;i++){
        colecao[i] = funcao_transformadora(colecao[i]);
    }
}
function mapear_v2(colecao:number[],funcao_transformadora:Function)  {
    colecao.forEach(function(elemento,i,array){array[i] = funcao_transformadora(elemento)});
}
function reduzir(colecao:number[],funcao_redutora:Function,acumulado: any=0) :any {
    for(let i of colecao){
        acumulado = funcao_redutora(acumulado,i);
    }return acumulado;
}
function reduzir_v2(colecao:number[],funcao_redutora:Function,acumulado: any=0) :any {
    colecao.forEach(function(elemento){acumulado=funcao_redutora(acumulado,elemento)})
    return acumulado;
}
class Numbers{
    numeros: number[] = [];
    constructor(arrays: number[]){
        for(let i = 0; i < arrays.length; i++){
            this.numeros[i] = arrays[i];
        }
    }dobrar(){
        mapear(this.numeros,(x:number)=>x*2)
    }
    dobrar_v2(){
        mapear_v2(this.numeros,(x:number)=>x*2)
    }
    mostrar_soma() {
        console.log(reduzir(this.numeros,(a:number,b:number)=>a+b));
    }
    mostrar_soma_v2() {
        console.log(reduzir_v2(this.numeros,(a:number,b:number)=>a+b));
    }
    mostrar_vetor_v2(){
        process.stdout.write("[ ");
        this.numeros.forEach(function(elemento){
            process.stdout.write(`| ${elemento} `);}) ;     
        console.log("| ]");
    }
}
let play_numbers : Numbers = new Numbers([1,2,3,4,5]);
play_numbers.mostrar_vetor_v2();
play_numbers.mostrar_soma_v2();
play_numbers.dobrar_v2();
play_numbers.mostrar_vetor_v2();