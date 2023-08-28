function print_vetor(vetor) {
    process.stdout.write("[ ");
    for (var i = 0; i < vetor.length; i++) {
        process.stdout.write("| ".concat(vetor[i], " "));
    }
    ;
    console.log("| ]");
}
var vetor = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
var filtrar = function (array, funcao_booleana) {
    var retorno = [];
    array.forEach(function (elemento) {
        if (funcao_booleana(elemento)) {
            retorno.push(elemento);
        }
    });
    return retorno;
};
function filtrar_v2(array, funcao_booleana) {
    var retorno = [];
    for (var _i = 0, array_1 = array; _i < array_1.length; _i++) {
        var i = array_1[_i];
        if (funcao_booleana(i)) {
            retorno.push(i);
        }
    }
    return retorno;
}
var pares = filtrar(vetor, function (x) { return x % 2 == 0; });
print_vetor(pares);
var pares_v2 = filtrar_v2(vetor, function (x) { return x % 2 == 0; });
print_vetor(pares_v2);
