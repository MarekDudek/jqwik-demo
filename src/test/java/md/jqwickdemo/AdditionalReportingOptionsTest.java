package md.jqwickdemo;

import net.jqwik.api.*;

import static net.jqwik.api.Reporting.FALSIFIED;
import static net.jqwik.api.Reporting.GENERATED;
import static org.assertj.core.api.Assertions.assertThat;

public class AdditionalReportingOptionsTest
{

    @Provide
    @SuppressWarnings("unused")
    private Arbitrary<Integer> average()
    {
        return Arbitraries.integers().between(0, Integer.MAX_VALUE / 2);
    }

    @Property
    @Report(value = {GENERATED, FALSIFIED})
    void test(@ForAll("average") int a, @ForAll("average") int b)
    {
        assertThat(a + b).isGreaterThanOrEqualTo(a);
        assertThat(a + b).isGreaterThanOrEqualTo(b);
    }
}
