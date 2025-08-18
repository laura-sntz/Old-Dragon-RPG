package org.example

class Personagem(
    val nome: String,
    val atributos: MutableList<Atributo>
) {
    fun exibirFicha() {
        println("\n--- Ficha do Personagem ---")
        println("Nome: $nome")
        atributos.forEach { println(it) }
    }
}
