fun main() {
    println("--- Калькулятор ---")
    println("Введите выражение в формате: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
    println("Доступные операции: +, -, *, /")
    println("Для выхода введите 'выход'")
    println("-".repeat(30))

    while (true) {
        print("Ввод(напишите 'выход' для завершения программы: ")
        val input = readln()

        if (input.equals("выход", ignoreCase = true)) {
            println("Программа завершена.")
            break
        }

        try {
            val result = calculatio(input)
            println("Результат: $result")
        } catch (e: IllegalArgumentException) {
            println("Ошибка: ${e.message}")
        } catch (e: ArithmeticException) {
            println("Ошибка: ${e.message}")
        }

        println() // Пустая строка для читаемости
    }
}

fun calculatio(input: String): Double {
    // Разделяем ввод по пробелам
    val parts = input.split(" ")

    // Проверяем количество частей
    if (parts.size != 3) {
        throw IllegalArgumentException("Неверный формат ввода. Используйте: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
    }

    val number1 = parts[0].toDoubleOrNull()
        ?: throw IllegalArgumentException("Первое число введено некорректно")

    val number2 = parts[1].toDoubleOrNull()
        ?: throw IllegalArgumentException("Второе число введено некорректно")

    val operation = parts[2]

    // Выполняем операцию
    return when (operation) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> {
            if (number2 == 0.0) {
                throw ArithmeticException("Деление на ноль невозможно")
            }
            number1 / number2
        }
        else -> throw IllegalArgumentException("Неизвестная операция: $operation. Доступные: +, -, *, /")
    }
}
