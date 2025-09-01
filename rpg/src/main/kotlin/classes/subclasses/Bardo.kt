package org.example.classes.subclasses
import org.example.classes.implementacoes.Ladrao

class Bardo : Ladrao() {

    override val nome = "Bardo"
    override val descricao = "Artistas e cronistas errantes. Inspiram aliados e vivem de astúcia e performance."
    override val habilidades = super.habilidades + listOf("Inspiração", "Performance", "Lábia e Histórias")
    override val subclasses = emptyList<String>()

}