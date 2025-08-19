package org.example.personagens.racas
import org.example.personagens.Raca

/* halflings: furtivos e precisos, porém com restrições de equipamento */

class Halfling : Raca {

    override val nome = "Halfling"
    override val movimentoBase = 6
    override val infravisao: Int? = null
    override val alinhamentoTendencia = "Tendem à neutralidade"
    override val habilidadesRaciais = listOf(
        "Furtivos (chance de 1-2 em 1d6 de se esconder; +1 em Furtividade se for Ladrão)",
        "Destemidos (+1 em testes de JPS)",
        "Bons de Mira (ataques à distância com armas de arremesso considerados fáceis)",
        "Pequenos (ataques de criaturas grandes ou maiores são difíceis)",
        "Restrições (somente armadura de couro feita sob medida; não podem usar armas grandes; armas médias contam como de duas mãos)"
    )

}