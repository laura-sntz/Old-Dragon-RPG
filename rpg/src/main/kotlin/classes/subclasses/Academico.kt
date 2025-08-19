package org.example.classes.subclasses
import org.example.classes.Classe

class Academico : Classe {

    override val nome = "Acadêmico"
    override val conceito = "Clérigos voltados ao conhecimento. Reverenciam as ciências e aplicam teoria em aventuras."
    override val habilidades = listOf("Erudição Sagrada", "Pesquisa e Arquivos", "Rituais Litúrgicos")
    override val subclasses = emptyList<String>()

}