package org.example

import org.example.atributos.Atributo
import org.example.atributos.NomeAtributo
import org.example.distribuicao.*
import org.example.personagens.Personagem
import org.example.personagens.Raca
import org.example.personagens.racas.*
import org.example.classes.*
import org.example.classes.subclasses.*

fun main() {
    val scanner = java.util.Scanner(System.`in`)

    // 1 - nome do personagem
    print("Digite o nome do personagem: ")
    val nomePersonagem = readLine()?.trim().takeUnless { it.isNullOrEmpty() } ?: "SemNome"

    // 2 - escolha da raça
    val racaPersonagem: Raca = escolherRaca(scanner)

    // 3 - escolha da classe
    val classeEscolhida: Classe = escolherClasse(scanner)

    // 4 - escolha do método de distribuição
    val metodo: MetodoDistribuicao = escolherMetodo(scanner)

    // 5 - gerar valores de atributos (6 números)
    val valores = metodo.gerarAtributos()
    println("\nValores gerados: $valores")

    // 6 - mapear os valores para os atributos
    val atributos = distribuirAtributos(scanner, valores)

    // 7 - criar e exibir ficha
    val personagem = Personagem(nomePersonagem, atributos, racaPersonagem, classeEscolhida)
    personagem.exibirFicha()
}

// funções auxiliares do console

private fun escolherRaca(scanner: java.util.Scanner): Raca {
    while (true) {
        println("\nEscolha a raça do personagem:")
        val racas = listOf("Humano", "Elfo", "Anão", "Halfling")
        racas.forEachIndexed { index, raca -> println("${index + 1} - $raca") }
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

private fun escolherClasse(scanner: java.util.Scanner): Classe {
    // 1) escolher classe base
    val classeBase: Classe
    while (true) {
        println("\nEscolha a classe do personagem:")
        val classesBase = listOf("Guerreiro", "Clérigo", "Ladrão", "Mago")
        classesBase.forEachIndexed { i, c -> println("${i + 1} - $c") }
        print("Opção: ")
        when (scanner.nextInt()) {
            1 -> { classeBase = Guerreiro(); break }
            2 -> { classeBase = Clerigo(); break }
            3 -> { classeBase = Ladrao(); break }
            4 -> { classeBase = Mago(); break }
            else -> println("Opção inválida. Tente novamente.")
        }
    }

    // 2) subclasse opcional
    print("Deseja escolher uma subclasse agora? (s/n): ")
    val resposta = scanner.next().trim().lowercase()
    if (resposta != "s") return classeBase

    // 3) menu de subclasses conforme a base
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

private fun escolherMetodo(scanner: java.util.Scanner): MetodoDistribuicao {
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

/* distribui os 6 valores gerados nos 6 atributos do jogo */
/* para o modo "Clássico", a ordem default é [FOR, DES, CON, INT, SAB, CAR] */
/* para os demais modos, o usuário escolhe a ordem manualmente */
private fun distribuirAtributos(scanner: java.util.Scanner, valores: List<Int>): List<Atributo> {
    val ordemPadrao = listOf(
        NomeAtributo.FORCA,
        NomeAtributo.DESTREZA,
        NomeAtributo.CONSTITUICAO,
        NomeAtributo.INTELIGENCIA,
        NomeAtributo.SABEDORIA,
        NomeAtributo.CARISMA
    )

    println("\nDeseja distribuir manualmente os valores? (s/n) [n = ordem clássica FOR,DES,CON,INT,SAB,CAR]")
    val manual = readLine()?.trim()?.lowercase() == "s"

    val atribuicoes = mutableListOf<Atributo>()
    val atributosDisponiveis = ordemPadrao.toMutableList()

    if (!manual) {
        // ordem clássica: valores[0] -> FOR, valores[1] -> DES, etc.
        for (i in ordemPadrao.indices) {
            atribuicoes += Atributo(ordemPadrao[i], valores[i])
        }
        return atribuicoes
    }

    // distribuição manual
    val valoresRestantes = valores.toMutableList()
    while (atributosDisponiveis.isNotEmpty()) {
        println("\nAtributos disponíveis:")
        atributosDisponiveis.forEachIndexed { i, a -> println("${i + 1} - ${a.name} (${a.sigla})") }
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
            continue
        }
        val valor = valoresRestantes.removeAt(escolhaVal - 1)
        val atributo = atributosDisponiveis.removeAt(escolhaAttr - 1)
        atribuicoes += Atributo(atributo, valor)
    }
    return atribuicoes
}