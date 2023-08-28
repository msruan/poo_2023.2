interface sensor {
    tipo_de_leitura: string,
    valor_leitura: number,
    data_hora: Date
}
interface sensor_infos {
    tipo_de_leitura: string,
    media: number,
    maximo: number,
    minimo: number
}
function lerSensor(tipo_de_leitura: string,valor_leitura: number,data_hora: Date): sensor{
    return {
        tipo_de_leitura: tipo_de_leitura,
        valor_leitura: valor_leitura,
        data_hora: data_hora
    }; 
}
function snake_to_normal(snake: string):string{
    let saida:string = snake[0].toLocaleUpperCase();
    for(let i = 1; i<snake.length;i++){
        if(snake[i]=="_"){
            saida += ` ${snake[i+1].toLocaleUpperCase()}`
            i++;
            continue;
        }
        saida += snake[i];
    }return saida;
}
function reduzir(array: sensor[],funcao_redutora: Function,acumulado=0):number{
    for(let item of array){
        acumulado = funcao_redutora(acumulado,item.valor_leitura)
    }return acumulado;
}

function processarSensores(sensores: sensor[]){
    let temperaturas = sensores.filter((x:sensor)=>{return(x.tipo_de_leitura=="temperatura")})
    let umidades = sensores.filter((x:sensor)=>{return(x.tipo_de_leitura=="umidade")})
    let niveis_de_poluicao = sensores.filter((x:sensor)=>{return(x.tipo_de_leitura=="nivel_de_poluicao")})
    let ruidos = sensores.filter((x:sensor)=>{return(x.tipo_de_leitura=="ruido")})
    let pix = [temperaturas,umidades,niveis_de_poluicao,ruidos]
    let infos_sensores: sensor_infos[] = []
    for(let item of pix){
        let info: sensor_infos = {
            tipo_de_leitura: item[0].tipo_de_leitura,
            media: reduzir(item,(x:number,y:number)=>{x+y})/item.length,
            maximo: reduzir(item,(x:number,y:number)=>{x+y},-9999999),
            minimo: number
        }; 
    }

    sensores[0].tipo_de_leitura
}
const data_teste: Date = new Date(sensor.data_hora)
