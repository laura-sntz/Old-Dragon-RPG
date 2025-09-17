package org.example.classes.implementacoes

import org.example.classes.base.Classe
import org.example.classes.base.NivelInfo
import org.example.classes.progresso.Progressoes

open class Clerigo : Classe {

    override val nome = "Clérigo"
    override val descricao = "Guerreiro-sagrado, canaliza o poder divino para curar e combater o mal."
    override val habilidades = listOf("Cura", "Expulsar Mortos-vivos")
    override val subclasses = listOf("Druida", "Acadêmico")

    // Sistema de XP
    private val progressao = Progressoes.clerigo

    fun getNivelPorXp(xp: Int): NivelInfo {
        return progressao
            .filter { xp >= it.xpNecessario }
            .maxByOrNull { it.nivel }
            ?: progressao.first()
    }
}