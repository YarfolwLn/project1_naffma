fun main() {
    println("--- Генератор нечетного числа из двух цифр ---")

    while (true) {
        try {
            println("\nВведите две различные цифры (0-9):")

            print("Первая цифра: ")
            val cifra1 = readln().toInt()

            print("Вторая цифра: ")
            val cifra2 = readln().toInt()

            // Проверка валидности цифр
            if (cifra1 !in 0..9 || cifra2 !in 0..9) {
                println("Ошибка: введите цифры от 0 до 9!")
                continue
            }

            if (cifra1 == cifra2) {
                println("Ошибка: цифры должны быть различными!")
                continue
            }

            // Попытка создать нечетное число
            val result = crnum(cifra1, cifra2)

            if (result != null) {
                println("Создано нечетное число: $result")
            } else {
                println("Создать нечетное число невозможно")
            }

            print("\nПродолжить? (напишите 'выход' для завершения программы): ")
            val prod = readln().trim()
            if (prod.equals("выход", ignoreCase = true)) {
                println("Программа завершена.")
                break
            }

        } catch (e: NumberFormatException) {
            println("Ошибка: введите корректные цифры!")
        }
    }
}

fun crnum(cifra1: Int, cifra2: Int): Int? {
    // Проверяем все возможные комбинации
    val number1 = cifra1 * 10 + cifra2
    val number2 = cifra2 * 10 + cifra1

    // Возвращаем первую подходящую нечетную комбинацию
    return when {
        number1 % 2 != 0 -> number1
        number2 % 2 != 0 -> number2
        else -> null
    }
}