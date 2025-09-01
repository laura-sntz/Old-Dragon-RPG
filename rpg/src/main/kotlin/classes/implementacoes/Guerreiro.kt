package org.example.classes.implementacoes

import org.example.classes.base.Classe
import org.example.classes.base.NivelInfo
import org.example.classes.progresso.Progressoes

open class Guerreiro : Classe {

    override val nome = "Guerreiro"
    override val descricao = "Combatente da linha de frente, especialista em armas e defesa."
    override val habilidades = listOf("Aparar", "Maestria em Arma")
    override val subclasses = listOf("Bárbaro", "Paladino")

    // Sistema de XP
    private val progressao = Progressoes.guerreiro

    fun getNivelPorXp(xp: Int): NivelInfo {
        return progressao
            .filter { xp >= it.xpNecessario }
            .maxByOrNull { it.nivel }
            ?: progressao.first()
    }
}