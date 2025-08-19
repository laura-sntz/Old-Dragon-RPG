package org.example.distribuicao
import kotlin.random.Random

// funções utilitárias de rolagem

private fun rolarDados(qtd: Int, faces: Int): Int =
    (1..qtd).sumOf { Random.nextInt(1, faces + 1) }

/* rola 4d6 e descarta o menor valor, somando os 3 maiores */
private fun rolar4d6DescartaMenor(): Int {
    val rolagens = List(4) { Random.nextInt(1, 7) }
    return rolagens.sortedDescending().take(3).sum()
}

// estilos de distribuição

/* estilo clássico 3d6 na ordem dos atributos */
/* aqui só geramos os 6 valores; o mapeamento para atributos acontece fora */
class EstiloClassico : MetodoDistribuicao {
    override fun gerarAtributos(): List<Int> = List(6) { rolarDados(3, 6) }
}

/* estilo aventureiro 3d6, mas o jogador pode distribuir como quiser */
/* geramos 6 valores; a UI/console decide em qual atributo cada valor entra */
class EstiloAventureiro : MetodoDistribuicao {
    override fun gerarAtributos(): List<Int> = List(6) { rolarDados(3, 6) }
}

/* estilo heróico 4d6 descartando o menor, geramos 6 valores */
class EstiloHeroico : MetodoDistribuicao {
    override fun gerarAtributos(): List<Int> = List(6) { rolar4d6DescartaMenor() }
}