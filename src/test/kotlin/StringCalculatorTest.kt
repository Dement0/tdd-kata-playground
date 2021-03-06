import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import helpers.addInt
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `Empty input returns 0`() {
        val input = ""
        val output = addInt(input)
        assertThat(output).isEqualTo(0)
    }

    @Test
    fun `String returns null`() {
        val input = "Horse"
        val output = addInt(input)
        assertThat(output).isEqualTo(0)
    }

    @Test
    fun `String of number returns Int`() {
        val input = "22"
        val output = addInt(input)
        assertThat(output).isEqualTo(22)
    }

    @Test
    fun `String of comma separated numbers returns Int`() {
        val input = "2,5"
        val output = addInt(input)
        assertThat(output).isEqualTo(7)
    }

    @Test
    fun `String of comma separated char and numbers returns Int`() {
        val input = "2,a"
        val output = addInt(input)
        assertThat(output).isEqualTo(2)
    }

    @Test
    fun `String of comma or semicolon separated numbers returns Int`() {
        val input = "2;5"
        val output = addInt(input)
        assertThat(output).isEqualTo(7)
    }

    @Test
    fun `String of comma or semicolon separated char and numbers returns Int`() {
        val input = "5;a"
        val output = addInt(input)
        assertThat(output).isEqualTo(5)
    }

    @Test
    fun `String of comma and semicolon separated numbers returns Int`() {
        val input = "5,;7"
        val output = addInt(input)
        assertThat(output).isEqualTo(12)
    }

    @Test
    fun `String of comma and semicolon separated char and numbers returns Int`() {
        val input = "5,;a"
        val output = addInt(input)
        assertThat(output).isEqualTo(5)
    }


    @Test
    fun `String of EOL separated numbers returns Int`() {
        val input = "5\na"
        val output = addInt(input)
        assertThat(output).isEqualTo(5)
    }

    @Test
    fun `String of EOL separated char and numbers returns Int`() {
        val input = "z\n3"
        val output = addInt(input)
        assertThat(output).isEqualTo(3)
    }

    @Test
    fun `String of 3 semicolon separated numbers returns Int`() {
        val input = "5;7;3"
        val output = addInt(input)
        assertThat(output).isEqualTo(15)
    }

    @Test
    fun `String of 3 comma separated numbers returns Int`() {
        val input = "5,7,3"
        val output = addInt(input)
        assertThat(output).isEqualTo(15)
    }

    @Test
    fun `String of 3 comma and semicolon separated numbers returns Int`() {
        val input = "5,7;3"
        val output = addInt(input)
        assertThat(output).isEqualTo(15)
    }

    @Test
    fun `String of 3 comma separated char and numbers returns Int`() {
        val input = "y,a,3"
        val output = addInt(input)
        assertThat(output).isEqualTo(3)
    }

    @Test
    fun `String of 3 comma separated chars returns 0`() {
        val input = "l, o, l"
        val output = addInt(input)
        assertThat(output).isEqualTo(0)
    }

    @Test
    fun `String of 3 semicolon separated chars returns 0`() {
        val input = "l; o; l"
        val output = addInt(input)
        assertThat(output).isEqualTo(0)
    }
}
