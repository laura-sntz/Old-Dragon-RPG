package org.example.classes.implementacoes

import org.example.classes.base.Classe
import org.example.classes.base.NivelInfo
import org.example.classes.progresso.Progressoes

open class Ladrao : Classe {

    override val nome = "Ladrão"
    override val descricao = "Especialista em furtividade, armadilhas e ataques de oportunidade."
    override val habilidades = listOf("Ataque Furtivo", "Furtividade")
    override val subclasses = listOf("Ranger", "Bardo")

    // Sistema de XP
    private val progressao = Progressoes.ladrao

    fun getNivelPorXp(xp: Int): NivelInfo {
        return progressao
            .filter { xp >= it.xpNecessario }
            .maxByOrNull { it.nivel }
            ?: progressao.first()
    }
}