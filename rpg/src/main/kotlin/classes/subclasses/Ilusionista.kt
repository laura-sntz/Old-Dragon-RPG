package org.example.classes.subclasses
import org.example.classes.implementacoes.Mago

class Ilusionista : Mago() {

    override val nome = "Ilusionista"
    override val descricao = "Magos focados em ilusões, ocultações e manipulação da percepção. Acabamento superior nas ilusões."
    override val habilidades = super.habilidades + listOf("Esculpir Ilusões", "Prestidigitação", "Ocultação Arcana")
    override val subclasses = emptyList<String>()

}