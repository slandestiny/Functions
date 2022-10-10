fun main() {
    val seconds = 39_600
    println("Был(а) в сети ${agoToText(seconds)}")
}

// функция, переводящая секунды в текст
fun agoToText(seconds: Int): String {

    val text: String = when (seconds) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> forMinutes(seconds)
        in 60 * 60 + 1..24 * 60 * 60 -> forHours(seconds)
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "вчера"
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "позавчера"
        else -> "давно"
    }
    return text
}

// вспомогательная функция для подбора окончания у минут
fun forMinutes(seconds: Int): String {
    val minutes = seconds / 60
    val resultMinutes: String = when (minutes) {
        1, 21, 31, 41, 51 -> "$minutes минуту назад"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
    return resultMinutes
}

// вспомогательная функция для подбора окончания у часов
fun forHours(seconds: Int): String {
    val hours = seconds / 60 / 60
    return when (hours) {
        1, 21, 31, 41, 51 -> "$hours час назад"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}
