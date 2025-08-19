package org.example.classes.subclasses
import org.example.classes.Classe

class Ilusionista : Classe {

    override val nome = "Ilusionista"
    override val conceito = "Magos focados em ilusões, ocultações e manipulação da percepção. Acabamento superior nas ilusões."
    override val habilidades = listOf("Esculpir Ilusões", "Prestidigitação", "Ocultação Arcana")
    override val subclasses = emptyList<String>()

}