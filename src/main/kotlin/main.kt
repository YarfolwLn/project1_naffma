fun main() {
    println("=== Меню программ ===\n")

    while (true) {
        println("Выберите программу для запуска:")
        println("1. Задание 1")
        println("2. Задание 2")
        println("3. Задание 3")
        println("4. Задание 4")
        println("5. Задание 5")
        println("6. Задание 6")
        println("0. Выход")

        print("\nВведите номер программы: ")
        val choice = readln()

        when (choice) {
            "1" -> runProgram1()
            "2" -> runProgram2()
            "3" -> runProgram3()
            "4" -> runProgram4()
            "5" -> runProgram5()
            "6" -> runProgram6()
            "0" -> {
                println("Программа завершена.")
                break
            }
            else -> println("Ошибка: введите число от 0 до 6!")
        }

        println("\n" + "=".repeat(40) + "\n")
    }
}

fun runProgram1() {
    println("\n---Задание 1---")
    print("Введите строку: ")
    val input = readln()

    var result = ""
    var count = 1

    for (i in 1 until input.length) {
        if (input[i] == input[i - 1]) {
            count++
        } else {
            result += input[i - 1]
            if (count > 1) {
                result += count.toString()
            }
            count = 1
        }
    }

    result += input[input.length - 1]
    if (count > 1) {
        result += count.toString()
    }

    println("Результат: $result")
}

// Программа 2
fun runProgram2() {
    println("\n---Задание 2---")
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

// Программа 3
fun runProgram3() {
    println("\n---Задание 3---")

    while (true) {
        print("Введите натуральное число (или 'выход' для завершения): ")
        val input = readln()

        if (input.equals("выход", ignoreCase = true)) {
            println("Возврат в главное меню...")
            break
        }

        if (input.isNullOrEmpty()) {
            println("Ошибка: Введите число!")
            continue
        }

        try {
            val number = input.toInt()

            if (number < 0) {
                println("Ошибка: Введите натуральное положительное число больше 0")
                continue
            }

            var n = number
            val dvchisl = mutableListOf<String>()

            while (n > 0) {
                dvchisl.add((n % 2).toString())
                n /= 2
            }

            val dvoich = dvchisl.reversed().joinToString("")
            println("Десятичное: $number -> Двоичное: $dvoich")

        } catch (e: NumberFormatException) {
            println("Ошибка: Введите корректное число!")
        }
    }
}

// Программа 4
fun runProgram4() {
    println("\n---Задание 4---")
    println("Введите выражение в формате: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
    println("Доступные операции: +, -, *, /")
    println("Для выхода введите 'выход'")
    println("-".repeat(30))

    while (true) {
        print("Ввод (напишите 'выход' для завершения программы): ")
        val input = readln()

        if (input.equals("выход", ignoreCase = true)) {
            println("Возврат в главное меню...")
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

        println()
    }
}

fun calculatio (input: String): Double {
    val parts = input.split(" ")

    if (parts.size != 3) {
        throw IllegalArgumentException("Неверный формат ввода. Используйте: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
    }

    val number1 = parts[0].toDoubleOrNull()
        ?: throw IllegalArgumentException("Первое число введено некорректно")

    val number2 = parts[1].toDoubleOrNull()
        ?: throw IllegalArgumentException("Второе число введено некорректно")

    val operation = parts[2]

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

// Программа 5
fun runProgram5() {
    println("\n---Задание 5---")
    println("Проверяет, существует ли целое y такое, что x^y = n")
    println("-".repeat(50))

    while (true) {
        try {
            print("Введите число n (или 'выход' для завершения): ")
            val Input = readln()

            if (Input.equals("выход", ignoreCase = true)) {
                println("Возврат в главное меню...")
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

// Программа 6
fun runProgram6() {
    println("\n---Задание 6---")

    while (true) {
        try {
            println("\nВведите две различные цифры (0-9):")

            print("Первая цифра: ")
            val cifra1 = readln().toInt()

            print("Вторая цифра: ")
            val cifra2 = readln().toInt()

            if (cifra1 !in 0..9 || cifra2 !in 0..9) {
                println("Ошибка: введите цифры от 0 до 9!")
                continue
            }

            if (cifra1 == cifra2) {
                println("Ошибка: цифры должны быть различными!")
                continue
            }

            val result = crnum(cifra1, cifra2)

            if (result != null) {
                println("Создано нечетное число: $result")
            } else {
                println("Создать нечетное число невозможно")
            }

            print("\nПродолжить? (напишите 'выход' для завершения программы): ")
            val prod = readln()
            if (prod.equals("выход", ignoreCase = true)) {
                println("Возврат в главное меню...")
                break
            }

        } catch (e: NumberFormatException) {
            println("Ошибка: введите корректные цифры!")
        }
    }
}

fun crnum(cifra1: Int, cifra2: Int): Int? {
    val number1 = cifra1 * 10 + cifra2
    val number2 = cifra2 * 10 + cifra1

    return when {
        number1 % 2 != 0 -> number1
        number2 % 2 != 0 -> number2
        else -> null
    }
}
