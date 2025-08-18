package org.example
import kotlin.random.Random

// Estilo Clássico - ordem fixa
class EstiloClassico : MetodoDistribuicao {
    override fun gerarAtributos(): List<Int> {
        return List(6) { rolarDados(3, 6) }
    }
}

// Estilo Aventureiro - 3d6 mas pode distribuir
class EstiloAventureiro : MetodoDistribuicao {
    override fun gerarAtributos(): List<Int> {
        return List(6) { rolarDados(3, 6) }
    }
}

// Estilo Heroico - 4d6, remove menor
class EstiloHeroico : MetodoDistribuicao {
    override fun gerarAtributos(): List<Int> {
        return List(6) { rolar4d6MenorDescarta() }
    }
}

// Funções auxiliares
fun rolarDados(qtd: Int, faces: Int): Int {
    return (1..qtd).sumOf { Random.nextInt(1, faces + 1) }
}

fun rolar4d6MenorDescarta(): Int {
    val rolagens = List(4) { Random.nextInt(1, 7) }
    return rolagens.sortedDescending().take(3).sum()
}
