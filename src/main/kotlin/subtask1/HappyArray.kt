package subtask1

import java.util.*

fun main() {
    HappyArray().convertToHappy(intArrayOf(1, 2, 2, 9, 93, 2, 6, 9, 6, 10)).forEach(::println)
}

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(originArray: IntArray): IntArray {
        var iterator = 1
        val array: MutableList<Int> = originArray.toCollection(LinkedList())
        while (iterator < array.size - 1) {
            if (array[iterator - 1] + array[iterator + 1] < array[iterator]) {
                //this is so sad
                array.removeAt(iterator)
                iterator=1
            }else iterator++
        }
        return array.toIntArray()
    }
}
