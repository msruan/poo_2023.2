"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.mostrar_vetor = void 0;
function mostrar_vetor(vetor) {
    process.stdout.write("[ ");
    for (var i = 0; i < vetor.length; i++) {
        process.stdout.write("| ".concat(vetor[i], " "));
    }
    ;
    console.log("| ]");
}
exports.mostrar_vetor = mostrar_vetor;
function mapear(colecao, funcao_transformadora) {
    for (var i = 0; i < colecao.length; i++) {
        colecao[i] = funcao_transformadora(colecao[i]);
    }
}
function mapear_v2(colecao, funcao_transformadora) {
    colecao.forEach(function (elemento, i, array) { array[i] = funcao_transformadora(elemento); });
}
function reduzir(colecao, funcao_redutora, acumulado) {
    if (acumulado === void 0) { acumulado = 0; }
    for (var _i = 0, colecao_1 = colecao; _i < colecao_1.length; _i++) {
        var i = colecao_1[_i];
        acumulado = funcao_redutora(acumulado, i);
    }
    return acumulado;
}
function reduzir_v2(colecao, funcao_redutora, acumulado) {
    if (acumulado === void 0) { acumulado = 0; }
    colecao.forEach(function (elemento) { acumulado = funcao_redutora(acumulado, elemento); });
    return acumulado;
}
var Numbers = /** @class */ (function () {
    function Numbers(arrays) {
        this.numeros = [];
        for (var i = 0; i < arrays.length; i++) {
            this.numeros[i] = arrays[i];
        }
    }
    Numbers.prototype.dobrar = function () {
        mapear(this.numeros, function (x) { return x * 2; });
    };
    Numbers.prototype.dobrar_v2 = function () {
        mapear_v2(this.numeros, function (x) { return x * 2; });
    };
    Numbers.prototype.mostrar_soma = function () {
        console.log(reduzir(this.numeros, function (a, b) { return a + b; }));
    };
    Numbers.prototype.mostrar_soma_v2 = function () {
        console.log(reduzir_v2(this.numeros, function (a, b) { return a + b; }));
    };
    Numbers.prototype.mostrar_vetor_v2 = function () {
        process.stdout.write("[ ");
        this.numeros.forEach(function (elemento) {
            process.stdout.write("| ".concat(elemento, " "));
        });
        console.log("| ]");
    };
    return Numbers;
}());
var play_numbers = new Numbers([1, 2, 3, 4, 5]);
play_numbers.mostrar_vetor_v2();
play_numbers.mostrar_soma_v2();
play_numbers.dobrar_v2();
play_numbers.mostrar_vetor_v2();
