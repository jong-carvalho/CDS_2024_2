

fun main() {

    for(i in 1..10) {
        println("Atual $i")
    }

    println("-----------------------------------------")

    for(i in 1..10){
        if(i == 5)
            break
        println("Atual $i")
    }

    println("-----------------------------------------")

    for(i in 1..10){
        if(i == 5)
            continue
        println("Atual $i")
    }
}