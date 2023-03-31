package md.jqwickdemo;

import net.jqwik.api.*;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FizzBuzzTests
{
    @Property
    boolean every_third_element_starts_with_Fizz(@ForAll("divisibleBy3") int i)
    {
        return fizzBuzz().get(i - 1).startsWith("Fizz");
    }

    @Provide
    @SuppressWarnings("unused")
    private Arbitrary<Integer> divisibleBy3()
    {
        return Arbitraries.
                integers().
                between(1, 100).
                filter(i -> i % 3 == 0);
    }

    private List<String> fizzBuzz()
    {
        return IntStream.
                range(1, 100).
                mapToObj(i -> {
                            boolean by3 = i % 3 == 0;
                            boolean by5 = i % 5 == 0;
                            return by3 && by5 ? "FizzBuzz"
                                    : by3 ? "Fizz"
                                    : by5 ? "Buzz"
                                    : String.valueOf(i);
                        }
                ).collect(toList());
    }
}
