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

    @Test
    fun when6CentsTwoCombinations(){

        //setup
        val expected = listOf(
            Change(6,0,0,0),
            Change(1,1,0,0)
        )

        //act
        val actual = makeChange(6)

        //assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun when11CentsFourCombinations(){

        //setup
        val expected = listOf(
            Change(11,0,0,0),
            Change(6,1,0,0),
            Change(1,2,0,0),
            Change(1,0,1,0)
        )

        //act
        val actual = makeChange(11)

        //assert
        assertThat(actual).isEqualTo(expected)
    }


}