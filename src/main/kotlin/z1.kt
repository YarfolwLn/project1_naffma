fun main() {
    print("Введите строку: ")
    val input = readln()

    val result = StringBuilder()
    var count = 1

    for (i in 1 until input.length) {
        if (input[i] == input[i - 1]) {
            count++
        } else {
            // Сам символ + количество если больше 1
            result.append(input[i - 1])
            if (count > 1) {
                result.append(count)
            }
            count = 1
        }
    }

    // Последний символ
    result.append(input[input.length - 1])
    if (count > 1) {
        result.append(count)
    }

    println("Результат:  ${result.toString()}")
}