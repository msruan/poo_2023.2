/*7. Reescreva o exemplo abaixo, mantendo a quebra de linhas usando template
strings e os valores Ely, 120.56 e TypeScript venham de variáveis declaradas
separadamente e “interpoladas” na string:
Ely
My payment time is 120.56
and
my preffered language is TypeScript*/
class Pessoa{
    nome : string;
    payment_time : number;
    pref_lang : string;
    constructor(nome: string = "Anonymous",pay: number = 100, lang: string = "JS"){
        this.nome = nome;
        this.payment_time = pay;
        this.pref_lang = lang;
    }
    apresentar(){
        console.log("*************");
        console.log(`\nHello everyone! My name is ${this.nome}.\nI think my payment time is ${this.payment_time}\nMy preffered language is ${this.pref_lang}!\nCall me maybe ;)`);
        console.log("*************");
    }
}