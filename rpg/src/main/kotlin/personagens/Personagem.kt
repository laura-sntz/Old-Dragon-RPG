package org.example.personagens
import org.example.atributos.Atributo
import org.example.classes.Classe

/* agrega os elementos de um Personagem: nome, atributos, raça e classe */

class Personagem(

    val nome: String,
    val atributos: List<Atributo>,
    val raca: Raca,
    val classe: Classe

) {

    fun exibirFicha() {
        println("\n===== FICHA DO PERSONAGEM =====")
        println("Nome: $nome")
        println("Raça: ${raca.nome}")

        // mostra "Classe base (Subclasse: X)" quando for subclasse
        val classeLinha = when (classe) {
            is org.example.classes.subclasses.Barbaro     -> "Guerreiro (Subclasse: ${classe.nome})"
            is org.example.classes.subclasses.Paladino    -> "Guerreiro (Subclasse: ${classe.nome})"
            is org.example.classes.subclasses.Druida      -> "Clérigo (Subclasse: ${classe.nome})"
            is org.example.classes.subclasses.Academico   -> "Clérigo (Subclasse: ${classe.nome})"
            is org.example.classes.subclasses.Ranger      -> "Ladrão (Subclasse: ${classe.nome})"
            is org.example.classes.subclasses.Bardo       -> "Ladrão (Subclasse: ${classe.nome})"
            is org.example.classes.subclasses.Ilusionista -> "Mago (Subclasse: ${classe.nome})"
            is org.example.classes.subclasses.Necromante  -> "Mago (Subclasse: ${classe.nome})"
            else -> classe.nome // classe base
        }
        println("Classe: $classeLinha")
        println("Conceito da Classe: ${classe.conceito}")

        println("Movimento: ${raca.movimentoBase} m")
        val infravisaoStr = raca.infravisao?.toString() ?: "Nenhuma"
        println("Infravisão: $infravisaoStr")
        println("Alinhamento: ${raca.alinhamentoTendencia}")

        println("\nAtributos:")
        atributos.forEach { a ->
            val modStr = if (a.modificador >= 0) "+${a.modificador}" else a.modificador.toString()
            println(" - ${a.nome.sigla} (${a.nome.name}): ${a.valor}  [mod: $modStr]")
        }

        if (classe.habilidades.isNotEmpty()) {
            println("\nHabilidades de Classe:")
            classe.habilidades.forEach { println(" - $it") }
        }

        if (raca.habilidadesRaciais.isNotEmpty()) {
            println("\nHabilidades Raciais:")
            raca.habilidadesRaciais.forEach { println(" - $it") }
        }

        println("================================\n")
    }

}