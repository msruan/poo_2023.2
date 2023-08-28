"use strict";
/*7. Reescreva o exemplo abaixo, mantendo a quebra de linhas usando template
strings e os valores Ely, 120.56 e TypeScript venham de variáveis declaradas
separadamente e “interpoladas” na string:
Ely
My payment time is 120.56
and
my preffered language is TypeScript*/
var Pessoa = /** @class */ (function () {
    function Pessoa(nome, pay, lang) {
        if (nome === void 0) { nome = "Anonymous"; }
        if (pay === void 0) { pay = 100; }
        if (lang === void 0) { lang = "JS"; }
        this.nome = nome;
        this.payment_time = pay;
        this.pref_lang = lang;
    }
    Pessoa.prototype.apresentar = function () {
        console.log("*************");
        console.log("\nHello everyone! My name is ".concat(this.nome, ".\nI think my payment time is ").concat(this.payment_time, "\nMy preffered language is ").concat(this.pref_lang, "!\nCall me maybe ;)"));
        console.log("*************");
    };
    return Pessoa;
}());
