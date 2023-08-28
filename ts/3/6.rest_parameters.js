function exibir() {
    var args = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        args[_i] = arguments[_i];
    }
    for (var _a = 0, args_1 = args; _a < args_1.length; _a++) {
        var i = args_1[_a];
        console.log(i);
    }
}
exibir("versão", 456, true, 9.78, [3, 2, 3]);
function ssnake_to_normal(snake) {
    var saida = snake[0].toLocaleUpperCase();
    for (var i = 1; i < snake.length; i++) {
        if (snake[i] == "_") {
            saida += " ".concat(snake[i + 1].toLocaleUpperCase());
            i++;
            continue;
        }
        saida += snake[i];
    }
    return saida;
}
exibir(ssnake_to_normal("urubu_dos_pixes"));
