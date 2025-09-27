fun main() {
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