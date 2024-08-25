fun main() {

    println("Digite um número")
    val num = readLine()

//    vai dar erro de nullSafety
//    num.toInt()

   val impressao =  if((num?.toInt() ?: (0 % 2)) == 0) "numero par" else "numero ímpar"

    println(impressao)

    println("-----------------------------------------------")

    println("Digite um nome:")
    val nome = readLine()

    if(nome == "Carla")
        println("Você é a ${nome}")
    else if(nome == "Natasha")
        println("Você é a ${nome}")
    else if(nome == "Bianca")
        println("Você é a ${nome}")
    else
        println("Nome inválido")

}