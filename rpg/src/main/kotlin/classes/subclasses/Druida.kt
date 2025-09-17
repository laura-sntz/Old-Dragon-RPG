package org.example.classes.subclasses
import org.example.classes.implementacoes.Clerigo

class Druida : Clerigo() {

    override val nome = "Druida"
    override val descricao = "Clérigos silvestres devotos da Deusa-Mãe. Guardiões do equilíbrio natural e guias de comunidades rurais."
    override val habilidades = super.habilidades +  listOf("Magias da Natureza", "Empatia com Animais", "Caminhar pelos Ermos")
    override val subclasses = emptyList<String>()

}