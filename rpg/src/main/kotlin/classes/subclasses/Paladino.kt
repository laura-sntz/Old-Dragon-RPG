package org.example.classes.subclasses
import org.example.classes.Classe

class Paladino : Classe {

    override val nome = "Paladino"
    override val conceito = "Guerreiros sagrados que mantêm Aparar e Maestria em Arma."
    override val habilidades = listOf("Aparar", "Maestria em Arma", "Aura Sagrada")
    override val subclasses: List<String> = emptyList()

}