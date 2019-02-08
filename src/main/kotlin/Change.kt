data class Change(
    val pennies: Int,
    val nickels: Int,
    val dimes: Int,
    val quarters: Int
)

fun makeChange(changeToMake: Int): List<Change> {
    return makeChangeAddNickels(changeToMake)
}

fun makeChangeAddNickels(changeToMake: Int): List<Change> {

    val changeCombinations = mutableListOf<Change>()

    val numberOfPenniesInANickel = 5
    val maxNickels = changeToMake / numberOfPenniesInANickel;

    for (i in 0..maxNickels){
        val valueInNickles = i * numberOfPenniesInANickel
        changeCombinations.add(makeChangeAddPennies(i,changeToMake- valueInNickles))
    }

    return changeCombinations
}

private fun makeChangeAddPennies(numberOfNickels: Int, changeToMake: Int): Change {
    return Change(changeToMake, numberOfNickels, 0, 0)
}