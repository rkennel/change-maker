data class Change(
    val pennies: Int,
    val nickels: Int,
    val dimes: Int,
    val quarters: Int
)

fun makeChange(changeToMake: Int): List<Change> {
    return makeChangeAddQuarters(changeToMake)
}

private fun makeChangeAddQuarters(changeToMake: Int): List<Change> {
    val changeCombinations = mutableListOf<Change>()

    val numberOfPenniesInAQuarter = 25
    val maxQuarters = changeToMake / numberOfPenniesInAQuarter;

    for (i in 0..maxQuarters) {
        val valueInQuarters = i * numberOfPenniesInAQuarter
        changeCombinations.addAll(makeChangeAddDimes(i, changeToMake - valueInQuarters))
    }

    return changeCombinations
}

private fun makeChangeAddDimes(numberOfQuarters:Int,changeToMake: Int): List<Change> {
    val changeCombinations = mutableListOf<Change>()

    val numberOfPenniesInADime = 10
    val maxDimes = changeToMake / numberOfPenniesInADime;

    for (i in 0..maxDimes) {
        val valueInDimes = i * numberOfPenniesInADime
        changeCombinations.addAll(makeChangeAddNickels(numberOfQuarters, i, changeToMake - valueInDimes))
    }

    return changeCombinations
}

private fun makeChangeAddNickels(numberOfQuarters: Int,numberOfDimes: Int, changeToMake: Int): List<Change> {

    val changeCombinations = mutableListOf<Change>()

    val numberOfPenniesInANickel = 5
    val maxNickels = changeToMake / numberOfPenniesInANickel;

    for (i in 0..maxNickels) {
        val valueInNickles = i * numberOfPenniesInANickel
        changeCombinations.addAll(makeChangeAddPennies(numberOfQuarters, numberOfDimes, i, changeToMake - valueInNickles))
    }

    return changeCombinations
}

private fun makeChangeAddPennies(numberOfQuarters: Int,numberOfDimes: Int, numberOfNickels: Int, changeToMake: Int): List<Change> {
    return mutableListOf(Change(changeToMake, numberOfNickels, numberOfDimes, numberOfQuarters))
}

