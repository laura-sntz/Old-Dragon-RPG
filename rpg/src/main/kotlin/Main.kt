package org.example
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val scanner = java.util.Scanner(System.`in`)

    println("Escolha o estilo de criação:")
    println("1 - Clássico (ordem fixa)")
    println("2 - Aventureiro (distribuição livre)")
    println("3 - Heroico (distribuição livre)")
    print("Opção: ")

    val opcao = scanner.nextInt()

    val estilo: MetodoDistribuicao = when (opcao) {
        1 -> EstiloClassico()
        2 -> EstiloAventureiro()
        3 -> EstiloHeroico()
        else -> {
            println("Opção inválida. Usando Estilo Clássico.")
            EstiloClassico()
        }
    }

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

    print("\nDigite o nome do personagem: ")
    val nomePersonagem = readln()
    val personagem = Personagem(nomePersonagem, atributos)

    personagem.exibirFicha()
}
