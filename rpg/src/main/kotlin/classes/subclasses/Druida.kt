package org.example.classes.subclasses
import org.example.classes.Classe

class Druida : Classe {

    override val nome = "Druida"
    override val conceito = "Clérigos silvestres devotos da Deusa-Mãe. Guardiões do equilíbrio natural e guias de comunidades rurais."
    override val habilidades = listOf("Magias da Natureza", "Empatia com Animais", "Caminhar pelos Ermos")
    override val subclasses = emptyList<String>()

}