package personagens

import distribuicao.EstiloAventureiro
import distribuicao.EstiloClassico
import distribuicao.EstiloHeroico
import distribuicao.MetodoDistribuicao
import org.example.atributos.Atributo
import org.example.atributos.NomeAtributo
import org.example.personagens.racas.*
import org.example.classes.base.Classe
import org.example.classes.implementacoes.*
import org.example.classes.subclasses.*
import personagens.racas.Elfo
import personagens.racas.Halfling
import personagens.racas.Humano
import personagens.racas.Raca
import java.util.*

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

        val classeLinha = when (classe) {
            is Barbaro     -> "Guerreiro (Subclasse: ${classe.nome})"
            is Paladino    -> "Guerreiro (Subclasse: ${classe.nome})"
            is Druida      -> "Clérigo (Subclasse: ${classe.nome})"
            is Academico   -> "Clérigo (Subclasse: ${classe.nome})"
            is Ranger      -> "Ladrão (Subclasse: ${classe.nome})"
            is Bardo       -> "Ladrão (Subclasse: ${classe.nome})"
            is Ilusionista -> "Mago (Subclasse: ${classe.nome})"
            is Necromante  -> "Mago (Subclasse: ${classe.nome})"
            else -> classe.nome
        }
        println("Classe: $classeLinha")
        println("Conceito da Classe: ${classe.descricao}")

        println("Movimento: ${raca.movimentoBase} m")
        println("Infravisão: ${raca.infravisao ?: "Nenhuma"}")
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

    companion object {
        fun criar(scanner: Scanner): Personagem {
            // 1 - nome
            print("Digite o nome do personagem: ")
            val nomePersonagem = readlnOrNull()?.trim().takeUnless { it.isNullOrEmpty() } ?: "SemNome"

            // 2 - raça
            val racaPersonagem = escolherRaca(scanner)

            // 3 - classe (com subclasse opcional)
            val classeEscolhida = escolherClasse(scanner)

            // 4 - método de distribuição
            val metodo = escolherMetodo(scanner)

            // 5 - valores
            val valores = metodo.gerarAtributos()
            println("\nValores gerados: $valores")

            // 6 - distribuir atributos
            val atributos = distribuirAtributos(scanner, valores, metodo)

            return Personagem(nomePersonagem, atributos, racaPersonagem, classeEscolhida)
        }

        // Funções Auxiliares de Criação
        private fun escolherRaca(scanner: Scanner): Raca {
            while (true) {
                println("\nEscolha a raça do personagem:")
                val racas = listOf("Humano", "Elfo", "Anão", "Halfling")
                racas.forEachIndexed {
                    index, raca -> println("${index + 1} - $raca")
                }
                print("Opção: ")
                when (scanner.nextInt()) {
                    1 -> return Humano()
                    2 -> return Elfo()
                    3 -> return Anao()
                    4 -> return Halfling()
                    else -> println("Opção inválida. Tente novamente.")
                }
            }
        }

        private fun escolherClasse(scanner: Scanner): Classe {
            val classeBase: Classe
            while (true) {
                println("\nEscolha a classe do personagem:")
                val classesBase = listOf("Guerreiro", "Clérigo", "Ladrão", "Mago")
                classesBase.forEachIndexed {
                    i, c -> println("${i + 1} - $c")
                }
                print("Opção: ")
                when (scanner.nextInt()) {
                    1 -> { classeBase = Guerreiro(); break }
                    2 -> { classeBase = Clerigo(); break }
                    3 -> { classeBase = Ladrao(); break }
                    4 -> { classeBase = Mago(); break }
                    else -> println("Opção inválida. Tente novamente.")
                }
            }
            print("Deseja escolher uma subclasse agora? (s/n): ")
            val resposta = scanner.next().trim().lowercase()
            if (resposta != "s")
                return classeBase
            return when (classeBase) {
                is Guerreiro -> {
                    println("\nSubclasses de Guerreiro:")
                    println("1 - Bárbaro")
                    println("2 - Paladino")
                    print("Opção: ")
                    when (scanner.nextInt()) {
                        1 -> Barbaro()
                        2 -> Paladino()
                        else -> {
                            println("Opção inválida. Mantendo classe base.")
                            classeBase
                        }
                    }
                }

                is Clerigo -> {
                    println("\nSubclasses de Clérigo:")
                    println("1 - Druida")
                    println("2 - Acadêmico")
                    print("Opção: ")
                    when (scanner.nextInt()) {
                        1 -> Druida()
                        2 -> Academico()
                        else -> {
                            println("Opção inválida. Mantendo classe base.")
                            classeBase
                        }
                    }
                }

                is Ladrao -> {
                    println("\nSubclasses de Ladrão:")
                    println("1 - Ranger")
                    println("2 - Bardo")
                    print("Opção: ")
                    when (scanner.nextInt()) {
                        1 -> Ranger()
                        2 -> Bardo()
                        else -> {
                            println("Opção inválida. Mantendo classe base.")
                            classeBase
                        }
                    }
                }

                is Mago -> {
                    println("\nSubclasses de Mago:")
                    println("1 - Ilusionista")
                    println("2 - Necromante")
                    print("Opção: ")
                    when (scanner.nextInt()) {
                        1 -> Ilusionista()
                        2 -> Necromante()
                        else -> {
                            println("Opção inválida. Mantendo classe base.")
                            classeBase
                        }
                    }
                }
                else -> classeBase
            }
        }

        private fun escolherMetodo(scanner: Scanner): MetodoDistribuicao {
            while (true) {
                println("\nEscolha o método de geração de atributos:")
                println("1 - Clássico (3d6 na ordem)")
                println("2 - Aventureiro (3d6, você distribui)")
                println("3 - Heróico (4d6 descarta o menor)")
                print("Opção: ")
                when (scanner.nextInt()) {
                    1 -> return EstiloClassico()
                    2 -> return EstiloAventureiro()
                    3 -> return EstiloHeroico()
                    else -> println("Opção inválida. Tente novamente.")
                }
            }
        }

        private fun distribuirAtributos(scanner: Scanner, valores: List<Int>, metodo: MetodoDistribuicao): List<Atributo> {
            val ordemPadrao = listOf(
                NomeAtributo.FORCA,
                NomeAtributo.DESTREZA,
                NomeAtributo.CONSTITUICAO,
                NomeAtributo.INTELIGENCIA,
                NomeAtributo.SABEDORIA,
                NomeAtributo.CARISMA
            )
            // Se for clássico → ordem fixa
        if (metodo is EstiloClassico) {
            val atribuicoes = mutableListOf<Atributo>()
            for (i in ordemPadrao.indices) {
                atribuicoes += Atributo(ordemPadrao[i], valores[i]) }
            return atribuicoes }

        // Se for aventureiro ou heróico → distribuição manual
        val atribuicoes = mutableListOf<Atributo>()
            val atributosDisponiveis = ordemPadrao.toMutableList()
            val valoresRestantes = valores.toMutableList()

            while (atributosDisponiveis.isNotEmpty()) {
                println("\nAtributos disponíveis:")
                atributosDisponiveis.forEachIndexed {
                    i, a -> println("${i + 1} - ${a.name} (${a.sigla})")
                }
                println("Valores restantes: $valoresRestantes")
                print("Escolha o atributo (1-${atributosDisponiveis.size}): ")
                val escolhaAttr = scanner.nextInt()
                if (escolhaAttr !in 1..atributosDisponiveis.size) {
                    println("Opção inválida.")
                    continue
                }
                print("Escolha o índice do valor (1-${valoresRestantes.size}) para atribuir a ${atributosDisponiveis[escolhaAttr - 1].name}: ")
                val escolhaVal = scanner.nextInt()
                if (escolhaVal !in 1..valoresRestantes.size) {
                    println("Opção inválida.")
                    continue }
                val valor = valoresRestantes.removeAt(escolhaVal - 1)
                val atributo = atributosDisponiveis.removeAt(escolhaAttr - 1)
                atribuicoes += Atributo(atributo, valor) }
            return atribuicoes
        }
    }
}
