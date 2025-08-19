package org.example.distribuicao

/* contrato para os diferentes estilos de distribuição de atributos */
/* cada implementação deve gerar 6 valores de atributos */

interface MetodoDistribuicao {

    fun gerarAtributos(): List<Int>

}