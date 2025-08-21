package org.example.atributos

/* representa um atributo de personagem (FOR, DES, CON, INT, SAB, CAR) */
/* data class é ideal aqui por ser um tipo-valor simples com igualdade estrutural */

data class Atributo(

    val nome: NomeAtributo,
    var valor: Int

) {

    /* modificador calculado conforme a tabela do Old Dragon 2 */
    val modificador: Int
        get() = when (valor) {
            3 -> -3
            4, 5 -> -2
            in 6..8 -> -1
            in 9..12 -> 0
            13, 14 -> 1
            15, 16 -> 2
            17, 18 -> 3
            19 -> 4
            else -> 0 // fallback caso valor esteja fora do intervalo esperado
        }
}