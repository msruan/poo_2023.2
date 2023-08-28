"use strict";
var Circulo = /** @class */ (function () {
    function Circulo(raio) {
        this.raio = 0;
        this.raio = raio;
    }
    Circulo.prototype.calcularComprimento = function () {
        console.log("O valor do comprimento \u00E9 ".concat((2 * Math.PI * this.raio).toFixed(2), " cm"));
    };
    Circulo.prototype.calcularArea = function () {
        console.log("O valor do \u00E1rea \u00E9 ".concat((Math.PI * Math.pow(this.raio, 2)).toFixed(2), " cm"));
    };
    return Circulo;
}());
var circulo1 = new Circulo(3);
circulo1.calcularArea();
circulo1.calcularComprimento();
