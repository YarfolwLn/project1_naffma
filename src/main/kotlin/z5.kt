fun main() {
    println("--- Поиск целочисленного показателя степени ---")
    println("Проверяет, существует ли целое y такое, что x^y = n")
    println("-".repeat(50))

    while (true) {
        try {
            print("Введите число n (или 'выход' для завершения): ")
            val Input = readln()

            if (Input.equals("выход", ignoreCase = true)) {
                println("Программа завершена.")
                break
            }

            val n = Input.toInt()

            print("Введите основание степени x: ")
            val x = readln().toInt()

            if (n <= 0) {
                println("Ошибка: число n должно быть положительным!")
                continue
            }

            val result = stepin(n, x)

            if (result != null) {
                println("Найден показатель: y = $result")
                println("  Проверка: $x^$result = ${Math.pow(x.toDouble(), result.toDouble()).toInt()}")
            } else {
                println("Целочисленный показатель не существует")
            }

        } catch (e: NumberFormatException) {
            println("Ошибка: введите корректные целые числа!")
        }

        println()
    }
}

fun stepin(n: Int, x: Int): Int? {
    if (n == 1) return 0
    if (x == n) return 1

    var y = 0
    var power = 1

    while (power <= n) {
        if (power == n) {
            return y
        }
        y++
        val nextPower = power * x
        if (nextPower / x != power) {
            break
        }
        power = nextPower
    }

    return null
}