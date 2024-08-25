fun main() {

    println("Soma: ${soma(3, 5)}")
    println("Subtracao: ${subtracao(7, 9)}")
    println("Multiplicacao: ${multiplicacao(2,4)}")

}

fun soma(a: Int, b: Int): Int{
    return a + b
}

fun subtracao(a: Int, b: Int) = a-b

val multiplicacao = fun (a: Int, b: Int) = a*b