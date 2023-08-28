"use strict";
var SituacaoFinanceira = /** @class */ (function () {
    function SituacaoFinanceira(valorCreditos, valorDebitos) {
        this.valorCreditos = valorCreditos;
        this.valorDebitos = valorDebitos;
    }
    SituacaoFinanceira.prototype.saldo = function () {
        return this.valorCreditos - this.valorDebitos;
    };
    return SituacaoFinanceira;
}());
var cliente = new SituacaoFinanceira(700, 500);
console.log("O valor atual do saldo \u00E9 ".concat(cliente.saldo(), "!"));
