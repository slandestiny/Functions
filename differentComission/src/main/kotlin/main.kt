fun main() {
    val cardType: String = "Visa"
    val lastMonthAmount: Double = 0.0
    val amount: Double = 10_000.0
    if (limit(cardType, lastMonthAmount, amount)) println("ЛИМИТ ПРЕВЫШЕН") else
        println(
            "Комиссия за перевод $amount рублей по карте/счету $cardType составила " + calculateComission(
                cardType = cardType,
                lastMonthAmount = lastMonthAmount,
                amount = amount
            ) + " рублей"
        )
}

// расчет комиссии для карт/счета в общем виде
fun calculateComission(
    cardType: String = "Vk Pay",
    lastMonthAmount: Double = 0.0,
    amount: Double
): Double {
    return when (cardType) {
        "Mastercard", "Maestro" -> comissionForMasterCardAndMaestro(lastMonthAmount, amount)
        "Visa", "Мир" -> comissionForVisaAndMir(amount)
        else -> 0.0
    }
}

// расчет комиссии для карт MasterCard и Maestro
fun comissionForMasterCardAndMaestro(lastMonthAmount: Double, amount: Double): Double {
    val maxMonthAmountForComission: Double = 75_000.00
    return if (lastMonthAmount > maxMonthAmountForComission) amount * 0.006 + 20 else 0.0
}

// расчет комиссии для карт Visa и Мир
fun comissionForVisaAndMir(amount: Double): Double {
    val minComission = 35.0
    return if (amount * 0.0075 > 35.0) amount * 0.0075 else 35.0
}

// функция, определяющая наличие превышение лимита по карте/счету
fun limit(cardType: String, lastMonthAmount: Double, amount: Double): Boolean {
    val maxMonthAmountForCard: Double = 600_000.0
    val maxAmountForCard: Double = 150_000.0
    val maxMonthAmountForPay: Double = 40_000.0
    val maxAmountForPay: Double = 15_000.0
    return when (cardType) {
        "Mastercard", "Maestro", "Visa", "Мир" -> lastMonthAmount > maxMonthAmountForCard || amount > maxAmountForCard
        "Vk Pay" -> lastMonthAmount > maxMonthAmountForPay || amount > maxAmountForPay
        else -> false
    }

}
