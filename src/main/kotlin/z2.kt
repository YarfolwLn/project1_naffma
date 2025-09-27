fun main() {
    println("Введите строку для анализа:")
    val input = readln()

    val charCount = mutableMapOf<Char, Int>()

    for (char in input) {
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }

    val sortedChars = charCount.toList()
        .sortedBy { it.first }

    println("\nРезультат:")
    for ((char, count) in sortedChars) {
        println("$char - $count")
    }
}