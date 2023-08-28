//3. Pesquise um exemplo na internet em que a tipagem dinâmica pode ser problemático.

const x = "10";
const y = 5;
const operacao = x * y; // Multiplicação de uma string com um número
console.log(operacao); // O resultado é 50
if ("" == false){
    console.log("PIX");
}
if (-1 == true){
    console.log("BOTA");
}
else{
    console.log("COCA");
}


//Agora imagine que o programador esperava que a operação resultasse em 1010101010. O uso posterior deste valor
//pode acarretar em problemas tanto de sintaxe quanto de semântica.