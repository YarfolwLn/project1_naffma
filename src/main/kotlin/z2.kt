fun main() {
    println("Введите строку для анализа:")
    val input = readln()

    // Подсчитываем количество каждого символа
    val charCount = mutableMapOf<Char, Int>()

    for (char in input) {
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }

    // Сортируем символы в алфавитном порядке
    val sortedChars = charCount.toList()
        .sortedBy { it.first }

    // Выводим результат
    println("\nРезультат:")
    for ((char, count) in sortedChars) {
        println("$char - $count")
    }
}