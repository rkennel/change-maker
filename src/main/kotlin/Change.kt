data class Change(
    val pennies: Int,
    val nickels: Int,
    val dimes: Int,
    val quarters:Int
)

fun makeChange(changeToMake: Int): List<Change> {
    return listOf<Change>(makeChangePennies(changeToMake))
}

private fun makeChangePennies(changeToMake: Int) : Change {
    return Change(changeToMake, 0, 0, 0)
}