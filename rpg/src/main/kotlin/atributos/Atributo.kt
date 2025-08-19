package org.example.atributos

/* representa um atributo de personagem (FOR, DES, CON, INT, SAB, CAR) */
/* data class é ideal aqui por ser um tipo-valor simples com igualdade estrutural */

data class Atributo(

    val nome: NomeAtributo,
    var valor: Int

) {

    /* modificador calculado conforme a tabela do old dragon 2 */
    /* usamos 'when' para mapear faixas de valores em modificadores */

    val modificador: Int
        get() = when (valor) {
            3 -> -3
            in 4..5 -> -2
            in 6..8 -> -1
            in 9..12 -> 0
            in 13..15 -> 1
            in 16..17 -> 2
            18 -> 3
            else -> 0 // proteção caso valor esteja fora do intervalo esperado
        }

    override fun toString(): String = "${nome.sigla} (${nome.name}): $valor (Mod: $modificador)"

}