

fun main() {

    var contador: Int = 1

    while(contador <= 10){
        println(contador)
        contador++
    }


    println("---------------------------------")
    do{
        println("Digite a opção:")
        val opcao = readLine()?.toIntOrNull()
        println("Você escolheu a opção $opcao")
    } while (opcao != -1)
    println("Até mais")

}