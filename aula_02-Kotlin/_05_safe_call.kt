

fun main() {

    var a = 1

    print(retornaNulo(a))

//testar pra mostrar que vai dar erro
    var nulo: Int

//    nulo = retornaNulo(a)
}

fun retornaNulo(a: Int): Int? {
    if(a < 5) return 10 else return null
}