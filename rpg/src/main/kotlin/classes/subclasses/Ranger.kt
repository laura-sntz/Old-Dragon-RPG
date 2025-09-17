package org.example.classes.subclasses
import org.example.classes.implementacoes.Ladrao

class Ranger : Ladrao() {

    override val nome = "Ranger"
    override val descricao = "Protetores das terras selvagens. Caçadores, rastreadores e companheiros de animais."
    override val habilidades = super.habilidades + listOf("Rastrear", "Sobrevivência nos Ermos", "Companheirismo Animal")
    override val subclasses = emptyList<String>()

}