
//5. Pesquise e, se encontrar, um exemplo onde o tipo any seria benéfico.
function show(label : any = "\n"): void{
    console.log(label);
}
function pix(){
    console.log("PIXXX")
}
while(true){
    show(true);
    show(1);
    show("pix");
}
//Quando temos uma função genérica como o conceito de output, onde não é necessário conhecimento do tipo de dado,
//o uso de any pode ajudar na reutilização de códgio, evitando a necessidade de se usar da sobrecarga de funções.
//PS: pode parecer meio contraditório o uso de um tipo "dinâmico" como any, já que o objetivo do TS é justamente tipar 
//os dados. Mas além do benefício citado acima, o tipo any pode ser muito útil quando levamos em consideração que o TS
//é relativamente novo, e ainda há muitos projetos baseados em JS fazendo a migração para este. Assim, a keyword any
//de certa forma permite a transição gradual desses códigos, permitindo que a tipagem explícita seja feita com calma.