package org.example.classes

/* contrato das classes de personagem */
/* mantém a descrição (conceito), habilidades e possíveis especializações */

interface Classe {

    val nome: String
    val conceito: String
    val habilidades: List<String>
    val subclasses: List<String> // nomes das especializações possíveis

}