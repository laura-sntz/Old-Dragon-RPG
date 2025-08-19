package org.example.classes.subclasses
import org.example.classes.Classe

class Barbaro : Classe {

    override val nome = "Bárbaro"
    override val conceito = "Guerreiros rústicos, ligados à natureza, resistentes e instintivos."
    override val habilidades = listOf("Fúria", "Instinto Selvagem")
    override val subclasses: List<String> = emptyList() // não tem subclasses

}