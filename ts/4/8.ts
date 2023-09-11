class Equipamento{
   ligado:boolean = false;


   liga(){
       if(!this.ligado)
           this.ligado = true;
   }
   desliga(){
       if(this.ligado)
           this.ligado = false;
   }
   estaLigado():boolean{
       return this.ligado;
   }
   inverte(){
       if(this.ligado)
           this.desliga()
       else
           this.liga()
   }
}
let airfriyer : Equipamento = new Equipamento();
console.log(airfriyer.estaLigado())
airfriyer.liga()
console.log(airfriyer.estaLigado())
airfriyer.desliga()
console.log(airfriyer.estaLigado())
airfriyer.inverte()
console.log(airfriyer.estaLigado())

