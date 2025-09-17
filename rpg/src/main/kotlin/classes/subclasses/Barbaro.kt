package org.example.classes.subclasses
import org.example.classes.implementacoes.Guerreiro

class Barbaro : Guerreiro() {

    override val nome = "Bárbaro"
    override val descricao = "Guerreiros rústicos, ligados à natureza, resistentes e instintivos."
    override val habilidades = super.habilidades + listOf("Fúria", "Instinto Selvagem")
    override val subclasses: List<String> = emptyList()

}