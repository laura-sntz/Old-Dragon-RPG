package org.example.classes.base

interface Classe {

    val nome: String
    val descricao: String
    val habilidades: List<String>
    val subclasses: List<String> // nomes das especializações possíveis

}