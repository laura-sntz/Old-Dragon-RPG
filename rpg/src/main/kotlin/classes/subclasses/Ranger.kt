package org.example.classes.subclasses
import org.example.classes.Classe

class Ranger : Classe {

    override val nome = "Ranger"
    override val conceito = "Protetores das terras selvagens. Caçadores, rastreadores e companheiros de animais."
    override val habilidades = listOf("Rastrear", "Sobrevivência nos Ermos", "Companheirismo Animal")
    override val subclasses = emptyList<String>()

}