package org.example.personagens
import org.example.atributos.Atributo
import org.example.personagens.Raca

class Personagem(
    val nome: String,
    val atributos: List<Atributo>,
    val raca: Raca
) {
    fun exibirFicha() {
        println("\n===== FICHA DO PERSONAGEM =====")
        println("Nome: $nome")
        println("Raça: ${raca.nome}")
        println("Movimento: ${raca.movimentoBase} metros")
        println("Infravisão: ${raca.infravisao ?: "Nenhuma"}")
        println("Alinhamento: ${raca.alinhamentoTendencia}")
        atributos.forEach { println("${it.nome.name}: ${it.valor}") }
    }
}