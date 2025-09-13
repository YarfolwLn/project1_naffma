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

            val n = Input?.toInt() ?: throw NumberFormatException()

            print("Введите основание степени x: ")
            val x = readln().toInt()

            if (x <= 1) {
                println("Ошибка: основание степени x должно быть больше 1!")
                continue
            }

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
        } catch (e: IllegalArgumentException) {
            println("Ошибка: ${e.message}")
        }

        println()
    }
}

fun stepin(n: Int, x: Int): Int? {
    // Особые случаи
    if (n == 1) return 0  // x^0 = 1 для любого x
    if (x == n) return 1  // x^1 = x

    var y = 0
    var power = 1

    // Ищем показатель степени
    while (power <= n) {
        if (power == n) {
            return y
        }
        y++
        // Проверяем переполнение
        val nextPower = power * x
        if (nextPower / x != power) { // Проверка на переполнение
            break
        }
        power = nextPower
    }

    return null
}