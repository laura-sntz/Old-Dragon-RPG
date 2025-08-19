package org.example.classes.subclasses
import org.example.classes.Classe

class Necromante : Classe {

    override val nome = "Necromante"
    override val conceito = "Estudiosos dos mistérios da vida e da morte. Manipulam energias relacionadas a ambos."
    override val habilidades = listOf("Canalizar Necromancia", "Compreensão dos Mortos", "Rituais Funestos")
    override val subclasses = emptyList<String>()

}