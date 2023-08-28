"use strict";
var TestaRetangulo = /** @class */ (function () {
    function TestaRetangulo() {
    }
    TestaRetangulo.exibirPerimetro = function (retangulo) {
        console.log("O per\u00EDmetro do ret\u00E2ngulo \u00E9 ".concat(retangulo.calcularPerimetro()));
    };
    return TestaRetangulo;
}());
var Retangulo = /** @class */ (function () {
    function Retangulo(base, altura) {
        if (base === void 0) { base = 0; }
        if (altura === void 0) { altura = 0; }
        this.l1 = base;
        this.l2 = altura;
    }
    Retangulo.prototype.calcularArea = function () {
        return this.l1 * this.l2;
    };
    Retangulo.prototype.calcularPerimetro = function () {
        return this.l1 * 2 + this.l2 * 2;
    };
    return Retangulo;
}());
var retangulo = new Retangulo(2, 4);
TestaRetangulo.exibirPerimetro(retangulo);
