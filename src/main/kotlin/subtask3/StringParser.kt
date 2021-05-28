package subtask3

import java.util.*

fun main() {
    println(
        StringParser().getResult(
            "Lorem <(ipsum [dolor <sit] amet), consectetur adipiscing elit>. " +
                    "Integer nec odio. Praesent libero. " +
                    "Sed cursus ante dapibus diam. Sed nisi. " +
                    "Nulla quis sem at nibh elementum imperdiet>. " +
                    "Duis sagittis ipsum. Praesent mauris. " +
                    "Fusce nec tellus sed augue semper porta. " +
                    "Mauris massa. Vestibulum lacinia arcu eget (nulla. " +
                    "Class aptent <taciti [sociosqu ad] litora torquent per conubia> nostra), per inceptos himenaeos."
        ).forEach(::println)
    )
}

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val regExpression = Regex("""[<(\[]""")
        val strings = LinkedList<String>()
        for (i in inputString.indices) {
            val firstChar = inputString[i].toString()
            if (firstChar.contains(regExpression)) {
                var count = 0
                val secondChar = when (inputString[i].toString()) {
                    "<" -> ">"
                    "(" -> ")"
                    else -> "]"
                }
                for (x in i until inputString.length) {
                    if (inputString[x].toString().contains(firstChar)) {
                        count++
                    }
                    if (inputString[x].toString().contains(secondChar)) {
                        count--
                        if (count == 0) {
                            strings.add(inputString.subSequence(i + 1, x).toString().trim())
                            break
                        }
                    }
                }
            }
        }
        return strings.toTypedArray()
    }
}
