package org.example.classes.progresso

import org.example.classes.base.NivelInfo

object Progressoes {
    val guerreiro = listOf(
        NivelInfo(1, 0, "10", 1, 5, 0),
        NivelInfo(2, 2000, "+1d10", 2, 5, 2500),
        NivelInfo(3, 4000, "+1d10", 3, 6, 5000),
        NivelInfo(4, 7000, "+1d10", 4, 6, 8500),
        NivelInfo(5, 10000, "+1d10", 5, 8, 11500),
        NivelInfo(6, 20000, "+1d10", 6, 8, 23000),
        NivelInfo(7, 30000, "+1d10", 7, 10, 33000),
        NivelInfo(8, 40000, "+1d10", 8, 10, 43000),
        NivelInfo(9, 50000, "+1d10", 9, 11, 53000),
        NivelInfo(10, 100000, "+1d10", 10, 11, 106000),
    )

    val clerigo = listOf(
        NivelInfo(1, 0, "8", 1, 5, 0),
        NivelInfo(2, 1500, "+1d8", 1, 5, 2000),
        NivelInfo(3, 3000, "+1d8", 1, 5, 4000),
        NivelInfo(4, 5500, "+1d8", 3, 7, 7000),
        NivelInfo(5, 8500, "+1d8", 3, 7, 10000),
        NivelInfo(6, 17000, "+1d8", 3, 7, 20000),
        NivelInfo(7, 27000, "+1d8", 5, 9, 30000),
        NivelInfo(8, 37000, "+1d8", 5, 9, 40000),
        NivelInfo(9, 47000, "+1d8", 5, 9, 50000),
        NivelInfo(10, 94000, "+1d8", 7, 11, 100000),
    )

    val ladrao = listOf(
        NivelInfo(1, 0, "6", 1, 5, 0),
        NivelInfo(2, 1000, "+1d6", 1, 5, 1500),
        NivelInfo(3, 2000, "+1d6", 2, 5, 3000),
        NivelInfo(4, 4000, "+1d6", 2, 5, 5500),
        NivelInfo(5, 7000, "+1d6", 3, 8, 8500),
        NivelInfo(6, 14000, "+1d6", 3, 8, 17000),
        NivelInfo(7, 24000, "+1d6", 4, 8, 27000),
        NivelInfo(8, 34000, "+1d6", 4, 8, 37000),
        NivelInfo(9, 44000, "+1d6", 5, 11, 47000),
        NivelInfo(10, 88000, "+1d6", 5, 11, 94000),
    )

    val mago = listOf(
        NivelInfo(1, 0, "4", 0, 5, 0),
        NivelInfo(2, 2500, "+1d4", 1, 5, 3000),
        NivelInfo(3, 5000, "+1d4", 1, 5, 6000),
        NivelInfo(4, 8500, "+1d4", 1, 5, 10000),
        NivelInfo(5, 11500, "+1d4", 2, 7, 13000),
        NivelInfo(6, 23000, "+1d4", 2, 7, 26000),
        NivelInfo(7, 33000, "+1d4", 2, 7, 36000),
        NivelInfo(8, 43000, "+1d4", 3, 7, 46000),
        NivelInfo(9, 53000, "+1d4", 3, 7, 56000),
        NivelInfo(10, 106000, "+1d4", 3, 10, 112000),
    )
}