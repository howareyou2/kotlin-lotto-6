package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class GenerateLotto() {
    fun issueLotto(): Lotto {
        val numbers = generateNumbers()
        return Lotto(numbers)
    }

    private fun generateNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}