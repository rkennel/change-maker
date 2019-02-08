data class Change(
    val pennies: Int,
    val nickels: Int,
    val dimes: Int,
    val quarters:Int
)

fun makeChange(changeToMake: Int): List<Change> {
    return listOf<Change>(Change(changeToMake,0,0,0))
}