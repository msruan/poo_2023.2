function traco(array) {
    var saida = "";
    array.forEach(function (elemento, indice) {
        saida += "".concat(elemento);
        if (indice != (array.length - 1)) {
            saida += "-";
        }
    });
    return saida;
}
console.log(traco([1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 43]));
