function print_vetor(vetor:any[]){
    process.stdout.write("[ ")
    for(let i = 0; i<vetor.length; i++){
        process.stdout.write(`| ${vetor[i]} `);
    };
    console.log("| ]")
}
const vetor = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];

const filtrar = (array:number[],funcao_booleana: Function)=>{
    let retorno : number[] = [];
    array.forEach(
        function(elemento){
            if(funcao_booleana(elemento)){
                retorno.push(elemento)}
            }
        )
    return retorno;
}
function filtrar_v2(array:number[],funcao_booleana: Function): number[]{
    let retorno : number[] = [];
    for(let i of array){
        if(funcao_booleana(i)){
            retorno.push(i)
        }
    }
    return retorno;
    }
    
const pares = filtrar(vetor,(x:number)=>x%2==0);
print_vetor(pares);
const pares_v2 = filtrar_v2(vetor,(x:number)=>x%2==0);
print_vetor(pares_v2);