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

    @Test
    fun when26Cents13Combinations(){
        //setup
        val expected = listOf(
            Change(26,0,0,0),
            Change(21,1,0,0),
            Change(16,2,0,0),
            Change(16,0,1,0),
            Change(11,3,0,0),
            Change(11,1,1,0),
            Change(6,4,0,0),
            Change(6,2,1,0),
            Change(6,0,2,0),
            Change(1,5,0,0),
            Change(1,3,1,0),
            Change(1,1,2,0),
            Change(1,0,0,1)
        )

        //act
        val actual = makeChange(26)

        //assert
        assertThat(actual).containsAll(expected)
        assertThat(expected).containsAll(actual)

    }


}