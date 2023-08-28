//4. Pesquise e exemplifique com um exemplo porque dizemos que a linguagem C,
//mesmo tendo tipagem estática, possui tipagem fraca.
int a = 23.0/3;
/*Aqui, o compilador permite este programa sem erros. Primeiro, ele converte implicitamente o inteiro 3
para 3.0(double) para poder operar com o 23.0/3. Em seguida, ele realiza a conversão do resultado truncado a parte 
inteira do número flutuante, ou seja, atribuindo o valor 7 à variável 'a'.
Essas conversões implícitas só são possíveis graças à tipagem fraca de C.*/