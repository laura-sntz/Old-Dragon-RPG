package org.example

import org.example.atributos.Atributo
import org.example.atributos.NomeAtributo
import org.example.distribuicao.EstiloAventureiro
import org.example.distribuicao.EstiloClassico
import org.example.distribuicao.EstiloHeroico
import org.example.distribuicao.MetodoDistribuicao
import org.example.personagens.Personagem
import org.example.personagens.racas.*
import org.example.personagens.Raca

fun main() {
    val scanner = java.util.Scanner(System.`in`)

    // 1 - Nome do personagem
    print("Digite o nome do personagem: ")
    val nomePersonagem = readln()

    // 2 - Escolha da raça
    val racaPersonagem: Raca
    while (true) {
        println("\nEscolha a raça do personagem:")
        val racas = listOf("Humano", "Elfo", "Anão", "Halfling")
        racas.forEachIndexed { index, raca -> println("${index + 1} - $raca") }
        print("Opção: ")
        val escolhaRaca = scanner.nextInt()

        racaPersonagem = when (escolhaRaca) {
            1 -> Humano()
            2 -> Elfo()
            3 -> Anao()
            4 -> Halfling()
            else -> {
                println("Opção inválida. Tente novamente.")
                continue
            }
        }
        break
    }

    // 3 - Escolha do estilo
    val estilo: MetodoDistribuicao
    while (true) {
        println("\nEscolha o estilo de criação:")
        println("1 - Clássico (ordem fixa)")
        println("2 - Aventureiro (distribuição livre)")
        println("3 - Heroico (distribuição livre)")
        print("Opção: ")
        val opcao = scanner.nextInt()

        estilo = when (opcao) {
            1 -> EstiloClassico()
            2 -> EstiloAventureiro()
            3 -> EstiloHeroico()
            else -> {
                println("Opção inválida. Tente novamente.")
                continue
            }
        }
        break
    }

    // 4 - Gerar atributos
    val valoresGerados = estilo.gerarAtributos()
    println("\nValores gerados: $valoresGerados")

    val atributos = mutableListOf<Atributo>()
    val atributosDisponiveis = NomeAtributo.values().toMutableList()

    if (estilo is EstiloClassico) {
        NomeAtributo.values().forEachIndexed { index, nome ->
            atributos.add(Atributo(nome, valoresGerados[index]))
        }
    } else {
        println("\nDistribua os valores nos atributos:")
        valoresGerados.forEach { valor ->
            println("\nValor atual: $valor")
            println("Atributos disponíveis:")
            atributosDisponiveis.forEachIndexed { idx, nome ->
                println("${idx + 1} - ${nome.sigla} (${nome.name})")
            }

            var escolhaValida = false
            while (!escolhaValida) {
                print("Escolha o número do atributo: ")
                val escolha = scanner.nextInt()
                if (escolha in 1..atributosDisponiveis.size) {
                    val atributoEscolhido = atributosDisponiveis[escolha - 1]
                    atributos.add(Atributo(atributoEscolhido, valor))
                    atributosDisponiveis.removeAt(escolha - 1)
                    escolhaValida = true
                } else {
                    println("Opção inválida. Tente novamente.")
                }
            }
        }
    }

    // 5 - Criar personagem
    val personagem = Personagem(nomePersonagem, atributos, racaPersonagem)
    personagem.exibirFicha()
}