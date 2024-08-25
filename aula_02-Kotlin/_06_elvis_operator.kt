

fun main() {

    val a: String = "correto"

    println(retornaNull(a))

    val b: String = "errado"

    println(retornaNull(b))

    val c: String = retornaNull(b) ?: "valor padrão"

    println(c)

}

fun retornaNull(a: String): String? {
    if(a.equals("correto")) return "Deu certo!" else return null
}