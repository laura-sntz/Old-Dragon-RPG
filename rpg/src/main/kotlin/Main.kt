import personagens.Personagem

fun main() {
    val scanner = java.util.Scanner(System.`in`)
    val personagem = Personagem.criar(scanner)
    personagem.exibirFicha()
}
