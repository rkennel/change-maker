data class Change(
    val pennies: Int,
    val nickels: Int,
    val dimes: Int,
    val quarters: Int
)

enum class Coin(val valueInPennies:Int){
    QUARTER(25),
    DIME(10),
    NICKEL(5),
    PENNY(1),
    NONE(0)
}

fun makeChange(changeToMake: Int): List<Change> {
    return makeChangeAddCoins(changeToMake,0,0,0,0,Coin.QUARTER)
}

private fun makeChangeAddCoins(
    changeToMake: Int,
    numberOfQuarters: Int,
    numberOfDimes: Int,
    numberOfNickels: Int,
    numberOfPennies: Int,
    coin: Coin
): List<Change> {
    val changeCombinations = mutableListOf<Change>()

    val maxCoins = changeToMake / coin.valueInPennies;

    for (i in 0..maxCoins) {

        val q = if(coin==Coin.QUARTER) i else numberOfQuarters
        val d = if(coin==Coin.DIME) i else numberOfDimes
        val n = if(coin==Coin.NICKEL) i else numberOfNickels

        val nextCoin = determineNextCoin(coin)

        val valueInCoins = i * coin.valueInPennies
        val remainingChangeToMake = changeToMake - valueInCoins

        if(nextCoin==Coin.NONE){
            changeCombinations.add(Change(remainingChangeToMake,n,d,q))
        }
        else{
            changeCombinations.addAll(makeChangeAddCoins(remainingChangeToMake,q,d,n,numberOfPennies,nextCoin))
        }
    }

    return changeCombinations
}

private fun determineNextCoin(coin: Coin): Coin {
    return when (coin) {
        Coin.QUARTER -> Coin.DIME
        Coin.DIME -> Coin.NICKEL
        else -> Coin.NONE
    }
}

