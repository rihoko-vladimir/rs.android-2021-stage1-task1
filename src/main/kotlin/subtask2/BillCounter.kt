package subtask2

import java.util.*
import kotlin.math.abs

fun main() {
    println(BillCounter().calculateFairlySplit(intArrayOf(3, 10, 2, 9, 18, 25, 45), 4, 69))
}

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, annaPosition: Int, annaContributed: Int): String {
        val annaWillPay = with(bill.toCollection(LinkedList()).apply { removeAt(annaPosition) }) {
            var sum = 0
            this.forEach { sum += it }
            return@with sum / 2
        }
        return if (annaContributed==annaWillPay) "Bon Appetit" else "${abs(annaContributed-annaWillPay)}"

    }
}
