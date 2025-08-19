package org.example.personagens.racas

import org.example.personagens.Raca

/* elfos: visão no escuro, boa percepção e imunidades clássicas */

class Elfo : Raca {

    override val nome = "Elfo"
    override val movimentoBase = 9
    override val infravisao: Int? = 18
    override val alinhamentoTendencia = "Tendem à neutralidade"
    override val habilidadesRaciais = listOf(
        "Percepção Natural",
        "Graciosos (+1 JPD)",
        "Arma Racial (+1 dano com arcos)",
        "Imunidade a Sono e Paralisia de Ghoul"
    )

}