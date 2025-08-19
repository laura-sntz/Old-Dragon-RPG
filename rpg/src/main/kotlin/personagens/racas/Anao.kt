package org.example.personagens.racas
import org.example.personagens.Raca

/* anões: robustos, bons em pedra e resistentes */

class Anao : Raca {

    override val nome = "Anão"
    override val movimentoBase = 6
    override val infravisao: Int? = 18
    override val alinhamentoTendencia = "Tendem à ordem"
    override val habilidadesRaciais = listOf(
        "Resistência a Venenos (+2 JPD)",
        "Detecção de Armadilhas em Pedra",
        "Conhecimento de Engenharia Subterrânea",
        "Arma Racial (+1 dano com machados e martelos)"
    )

}