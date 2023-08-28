var saudacao = function (nome, pronome) {
    if (pronome === void 0) { pronome = "Sr"; }
    console.log("Oi! Tudo bem ".concat(pronome, ". ").concat(nome, "?"));
};
function Saudacao(nome, pronome) {
    if (pronome === void 0) { pronome = "Sr"; }
    console.log("Ol\u00E1! Como vai voc\u00EA hoje ".concat(pronome, ". ").concat(nome, "?"));
}
;
var Saudacoes = /** @class */ (function () {
    function Saudacoes(n, p) {
        this.nome = n;
        this.pronome = p;
    }
    Saudacoes.prototype.ola = function () {
        console.log("Oba! Tudo em cima ".concat(this.pronome, ". ").concat(this.nome, "?"));
    };
    Saudacoes.prototype.tchau = function () {
        console.log("At\u00E9 logo ".concat(this.pronome, ". ").concat(this.nome, "!"));
    };
    return Saudacoes;
}());
var exemplo = new Saudacoes("Juju do Pix", "Sra");
exemplo.ola();
exemplo.tchau();
saudacao(exemplo.nome, exemplo.pronome);
Saudacao(exemplo.nome, exemplo.pronome);
