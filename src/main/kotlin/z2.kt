fun main() {
    println("Введите строку для анализа:")
    val input = readln()
    println("\nРезультат:")

    for (c in 0..255) {
        val s = c.toChar()
        var count = 0

        for (inputC in input) {
            if (inputC == s) {
                count++
            }
        }

        if (count > 0) {
            println("$s - $count")
        }
    }
}