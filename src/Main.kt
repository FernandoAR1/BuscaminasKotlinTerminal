fun menu():Int{
    println("1.descubrir casilla")
    println("2.poner bandera")
    println("3.quitar bandera")
    println("4.salir")
    print("Introduce una opcion: ")
    return readln().toInt()
}
fun main(){

    print("Introduce el tamaño del tablero: ")
    val size = readln().toInt()
    print("Introduce el numero de minas: ")
    val numminas = readln().toInt()

    val game =Buscaminas(size, numminas)
    game.creartablero()
    game.ponerminas()
    println(game.vervistatablero())
    while (true){
        when(menu()){
            1->{
                print("Introduce la fila: ")
                val fila = readln().toInt()-1
                print("Introduce la columna: ")
                val columna = readln().toInt()-1
                if (game.destapar(fila, columna)){
                    println("Has perdido")
                    println(game.vervistatablero())
                    break
                }
                else{
                    println(game.vervistatablero())
                }
            }
            2->{
                print("Introduce la fila: ")
                val fila = readln().toInt()-1
                print("Introduce la columna: ")
                val columna = readln().toInt()-1
                game.ponerbandera(fila, columna)
                println(game.vervistatablero())
            }
            3->{
                print("Introduce la fila: ")
                val fila = readln().toInt()-1
                print("Introduce la columna: ")
                val columna = readln().toInt()-1
                game.quitarbandera(fila, columna)
                println(game.vervistatablero())
            }
            4-> {
                break
            }
        }
        if (game.ganar()){
            println("Has ganado")
            break
        }
    }
}