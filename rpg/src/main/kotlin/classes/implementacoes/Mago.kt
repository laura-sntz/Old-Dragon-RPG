package org.example.classes.implementacoes

import org.example.classes.base.Classe
import org.example.classes.base.NivelInfo
import org.example.classes.progresso.Progressoes

open class Mago : Classe {

    override val nome = "Mago"
    override val descricao = "Estudioso das artes arcanas, conjura magias a partir de grimórios."
    override val habilidades = listOf("Magia Arcana", "Leitura de Grimórios")
    override val subclasses = listOf("Ilusionista", "Necromante")

    // Sistema de XP
    private val progressao = Progressoes.mago

    fun getNivelPorXp(xp: Int): NivelInfo {
        return progressao
            .filter { xp >= it.xpNecessario }
            .maxByOrNull { it.nivel }
            ?: progressao.first()
    }
}