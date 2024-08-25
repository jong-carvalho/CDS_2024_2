
fun main() {

    println("Digite a nota do aluno:")
    val nota = readLine()?.toInt()


    when(nota){
        10, 9, 8 -> println("Parabéns, você é um aluno exemplar")
        7, 6 -> println("Você não fez mais que a obrigação")
        5, 4, 3 -> println("Como você conseguiu a proeza de ficar de exame em uma disciplina tão fácil?")
        2, 1, 0 -> println("Parabéns, você conseguiu ser reprovado!")
        else -> print("Nota fora dos parametros")
    }


}