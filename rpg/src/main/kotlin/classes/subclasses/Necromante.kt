package org.example.classes.subclasses
import org.example.classes.implementacoes.Mago

class Necromante : Mago() {

    override val nome = "Necromante"
    override val descricao = "Estudiosos dos mistérios da vida e da morte. Manipulam energias relacionadas a ambos."
    override val habilidades = super.habilidades + listOf("Canalizar Necromancia", "Compreensão dos Mortos", "Rituais Funestos")
    override val subclasses = emptyList<String>()

}