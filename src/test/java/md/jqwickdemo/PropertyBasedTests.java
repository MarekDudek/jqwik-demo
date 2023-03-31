package md.jqwickdemo;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertyBasedTests
{
    @Property
    boolean absoluteValueOfAllNumbersIsPositive
            (
                    @ForAll int integer
            )
    {
        if (integer == -2147483648) {
            return Math.abs(integer) < 0;
        }
        return Math.abs(integer) >= 0;
    }

    @Property
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach
            (
                    @ForAll String string1,
                    @ForAll String string2
            )
    {
        String concatenated = string1 + string2;
        assertThat(concatenated.length()).isGreaterThanOrEqualTo(string1.length());
        assertThat(concatenated.length()).isGreaterThanOrEqualTo(string2.length());
    }
}
