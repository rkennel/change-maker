data class Change(
    val pennies: Int,
    val nickels: Int,
    val dimes: Int,
    val quarters: Int
)



fun makeChange(changeToMake: Int): List<Change> {
    return makeChangeAddQuarters(changeToMake, 0, 0, 0, 0)
}



private fun makeChangeAddQuarters(
    changeToMake: Int,
    numberOfQuarters: Int,
    numberOfDimes: Int,
    numberOfNickels: Int,
    numberOfPennies: Int
): List<Change> {
    val changeCombinations = mutableListOf<Change>()

    val numberOfPenniesInAQuarter = 25
    val maxQuarters = changeToMake / numberOfPenniesInAQuarter;

    for (i in 0..maxQuarters) {
        val valueInQuarters = i * numberOfPenniesInAQuarter
        changeCombinations.addAll(
            makeChangeAddDimes(
                changeToMake - valueInQuarters,
                i,
                numberOfDimes,
                numberOfNickels,
                numberOfPennies
            )
        )
    }

    return changeCombinations
}

private fun makeChangeAddDimes(
    changeToMake: Int,
    numberOfQuarters: Int,
    numberOfDimes: Int,
    numberOfNickels: Int,
    numberOfPennies: Int
): List<Change> {
    val changeCombinations = mutableListOf<Change>()

    val numberOfPenniesInADime = 10
    val maxDimes = changeToMake / numberOfPenniesInADime;

    for (i in 0..maxDimes) {
        val valueInDimes = i * numberOfPenniesInADime
        changeCombinations.addAll(
            makeChangeAddNickels(
                changeToMake - valueInDimes,
                numberOfQuarters,
                i,
                numberOfNickels,
                numberOfPennies
            )
        )
    }

    return changeCombinations
}

private fun makeChangeAddNickels(
    changeToMake: Int,
    numberOfQuarters: Int,
    numberOfDimes: Int,
    numberOfNickels: Int,
    numberOfPennies: Int
): List<Change> {

    val changeCombinations = mutableListOf<Change>()

    val numberOfPenniesInANickel = 5
    val maxNickels = changeToMake / numberOfPenniesInANickel;

    for (i in 0..maxNickels) {
        val valueInNickles = i * numberOfPenniesInANickel
        changeCombinations.addAll(
            makeChangeAddPennies(
                changeToMake - valueInNickles,
                numberOfQuarters,
                numberOfDimes,
                i,
                numberOfPennies
            )
        )
    }

    return changeCombinations
}

private fun makeChangeAddPennies(
    changeToMake: Int,
    numberOfQuarters: Int,
    numberOfDimes: Int,
    numberOfNickels: Int,
    numberOfPennies: Int
): List<Change> {
    return mutableListOf(Change(changeToMake, numberOfNickels, numberOfDimes, numberOfQuarters))
}

