import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChangeTest {

    @Test
    fun when3CentsOneCombination(){

        //setup
        val expected = listOf(Change(3,0,0,0))

        //act
        val actual = makeChange(3)

        //assert
        assertThat(actual).isEqualTo(expected)

    }

}