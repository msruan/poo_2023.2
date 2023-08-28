//const readline = require('readline-sync') 
//import {question} from 'readline-sync'
var eh_par = function (numero) { return numero % 2 == 0; };
function ehPar(numero) {
    return numero % 2 == 0;
}
var Par = /** @class */ (function () {
    function Par() {
    }
    Par.eh_par = function (numero) {
        return numero % 2 == 0;
    };
    Par.eh_impar = function (numero) {
        return Boolean(numero % 2);
    };
    Par.mostrar_paridade = function (numero) {
        if (this.eh_impar(numero))
            console.log("É ímpar...");
        else
            console.log("É par...");
    };
    return Par;
}());
console.log(typeof (eh_par));
console.log(typeof ("pix"));
