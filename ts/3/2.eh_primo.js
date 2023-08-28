function array_contem_elemento(colecao, numero) {
    for (var _i = 0, colecao_1 = colecao; _i < colecao_1.length; _i++) {
        var i = colecao_1[_i];
        if (i == numero) {
            return true;
        }
    }
    return false;
}
var eh_primo = function (x) { return array_contem_elemento([1, 2, 3, 5, 7], x) || (((x % 2 != 0 && x % 3 != 0) && (x % 5 != 0 && x % 7 != 0))); };
function ehPrimo(x) {
    return (array_contem_elemento([1, 2, 3, 5, 7], x) || ((x % 2 != 0) && (x % 3 != 0) && (x % 5 != 0 && x % 7 != 0)));
}
;
var Primo = /** @class */ (function () {
    function Primo(x) {
        this.x = x;
    }
    Primo.prototype.eh_primo = function () {
        console.log((array_contem_elemento([1, 2, 3, 5, 7], this.x) || ((this.x % 2 != 0) && (this.x % 3 != 0) && (this.x % 5 != 0 && this.x % 7 != 0))) ? "É primo!!!" : "Não é primo!");
    };
    return Primo;
}());
;
var a = new Primo(2);
a.eh_primo();
console.log(ehPrimo(a.x));
console.log(eh_primo(5));
console.log(eh_primo(3));
console.log(eh_primo(7));
console.log(eh_primo(197));
console.log(eh_primo(13));
console.log(eh_primo(15));
