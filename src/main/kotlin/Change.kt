data class Change(
    val pennies: Int = 0,
    val nickels: Int = 0,
    val dimes: Int = 0,
    val quarters: Int = 0
)

enum class Coin(val valueInPennies:Int){
    QUARTER(25),
    DIME(10),
    NICKEL(5),
    PENNY(1),
    NONE(0)
}

fun makeChange(changeToMake: Int): List<Change> {
    return makeChangeAddCoins(changeToMake,Change(),Coin.QUARTER)
}

private fun makeChangeAddCoins(
    changeToMake: Int,
    currentChange: Change,
    coin: Coin
): List<Change> {

    if(coin==Coin.PENNY){
        return listOf(Change(changeToMake,currentChange.nickels,currentChange.dimes,currentChange.quarters))
    }

    val changeCombinations = mutableListOf<Change>()

    val maxCoins = changeToMake / coin.valueInPennies;

    for (i in 0..maxCoins) {

        val updatedChange = Change(
            0,
            if(coin==Coin.NICKEL) i else currentChange.nickels,
            if(coin==Coin.DIME) i else currentChange.dimes,
            if(coin==Coin.QUARTER) i else currentChange.quarters
        )

        val valueInCoins = i * coin.valueInPennies
        val remainingChangeToMake = changeToMake - valueInCoins

        changeCombinations.addAll(makeChangeAddCoins(remainingChangeToMake,updatedChange,determineNextCoin(coin)))
    }

    return changeCombinations
}

private fun determineNextCoin(coin: Coin): Coin {
    return when (coin) {
        Coin.QUARTER -> Coin.DIME
        Coin.DIME -> Coin.NICKEL
        Coin.NICKEL -> Coin.PENNY
        else -> Coin.NONE
    }
}

