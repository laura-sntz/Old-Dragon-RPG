package org.example.personagens.racas

import org.example.personagens.Raca

/* humanos: adaptáveis, sem infravisão, movimento mais alto */

class Humano : Raca {

    override val nome = "Humano"
    override val movimentoBase = 9
    override val infravisao: Int? = null
    override val alinhamentoTendencia = "Qualquer alinhamento"
    override val habilidadesRaciais = listOf("Aprendizado", "Adaptabilidade")

}