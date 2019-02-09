data class Change(
    val pennies: Int,
    val nickels: Int,
    val dimes: Int,
    val quarters: Int
)

fun makeChange(changeToMake: Int): List<Change> {
    return makeChangeAddDimes(changeToMake)
}

fun makeChangeAddDimes(changeToMake: Int): List<Change> {
    val changeCombinations = mutableListOf<Change>()

    val numberOfPenniesInADime = 10
    val maxDimes = changeToMake / numberOfPenniesInADime;

    for (i in 0..maxDimes){
        val valueInDimes = i * numberOfPenniesInADime
        changeCombinations.addAll(makeChangeAddNickels(i,changeToMake- valueInDimes))
    }

    return changeCombinations
}

private fun makeChangeAddNickels(numberOfDimes:Int,changeToMake: Int): List<Change> {

    val changeCombinations = mutableListOf<Change>()

    val numberOfPenniesInANickel = 5
    val maxNickels = changeToMake / numberOfPenniesInANickel;

    for (i in 0..maxNickels){
        val valueInNickles = i * numberOfPenniesInANickel
        changeCombinations.add(makeChangeAddPennies(numberOfDimes, i,changeToMake- valueInNickles))
    }

    return changeCombinations
}

private fun makeChangeAddPennies(numberOfDimes:Int, numberOfNickels: Int, changeToMake: Int): Change {
    return Change(changeToMake, numberOfNickels, numberOfDimes, 0)
}