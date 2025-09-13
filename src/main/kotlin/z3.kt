fun main() {
    println("=== Конвертер десятичных чисел в двоичные ===")

    while (true) {
        print("Введите натуральное число (или 'выход' для завершения): ")
        val input = readln()

        if (input.equals("выход", ignoreCase = true)) {
            println("Программа завершена.")
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

            var dvoich = dvchisl.reversed().joinToString("")

            println("Десятичное: $number -> Двоичное: $dvoich")

        } catch (e: NumberFormatException) {
            println("Ошибка: Введите корректное число!")
        }

    }
}