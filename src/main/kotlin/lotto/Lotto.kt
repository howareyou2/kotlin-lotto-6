package lotto

import lotto.domain.LottoRank
import lotto.domain.WinningNumber

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.distinct().size == 6)
    }

    fun compareNumber(winningNumber: WinningNumber): Pair<Int, Boolean> {
        val comparisonNumbers = winningNumber.getWinningNumbers()
        val matchNumbers = numbers.intersect(comparisonNumbers.toSet()).size
        val comparisonBonus = winningNumber.getBonusNumber()
        val matchBonus = numbers.contains(comparisonBonus)
        return Pair(matchNumbers, matchBonus)
    }

    fun printLottoNumber() {
        println(numbers.joinToString(separator = ", ", prefix = "[", postfix = "]"))
    }

    fun resultOfLotto(compareResult: Pair<Int, Boolean>): LottoRank {
        return LottoRank.fromMatches(compareResult.first, compareResult.second)
    }
}
