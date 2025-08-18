package org.example.atributos

data class Atributo(
    val nome: NomeAtributo,
    var valor: Int
) {
    val modificador: Int
        get() = when (valor) {
            3 -> -3
            in 4..5 -> -2
            in 6..8 -> -1
            in 9..12 -> 0
            in 13..15 -> 1
            in 16..17 -> 2
            18 -> 3
            else -> 0 // segurança, caso caia fora do esperado
        }

    override fun toString(): String {
        return "${nome.sigla} (${nome.name}): $valor (Mod: $modificador)"
    }
}