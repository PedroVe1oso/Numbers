package com.aor.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DivisibleByFilterTest {


    //DivideBy2
    @Test
    void accept2() {
        DivisibleByFilter filter = new DivisibleByFilter(2);
        List<Integer> divisible = Arrays.asList(0, 2, 4, 8, 240, 1000, 10000);
        List<Integer> notDivisible = Arrays.asList(1, 3, 5, 15, 351, 10001);

        for (int n : divisible)
            assertTrue(filter.accept(n));

        for (int n : notDivisible)
            assertFalse(filter.accept(n));

    }

    //DivideBy3
    @Test
    void accept3() {
        DivisibleByFilter filter = new DivisibleByFilter(3);
        List<Integer> divisible = Arrays.asList(0, 3, 6, 9, 33, 333, 666);
        List<Integer> notDivisible = Arrays.asList(1, 2, 4, 5, 100, 1000, 10000);

        for (int n : divisible)
            assertTrue(filter.accept(n));

        for (int n : notDivisible)
            assertFalse(filter.accept(n));

    }

    //DivideBy4
    @Test
    void accept4() {
        DivisibleByFilter filter = new DivisibleByFilter(4);
        List<Integer> divisible = Arrays.asList(0, 4, 8, 12, 16, 444, 888);
        List<Integer> notDivisible = Arrays.asList(1, 2, 3, 5, 90);

        for (int n : divisible)
            assertTrue(filter.accept(n));

        for (int n : notDivisible)
            assertFalse(filter.accept(n));

    }
}
