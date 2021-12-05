package com.aor.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveFilterTest {

    @Test
    void accept() {
        PositiveFilter filter = new PositiveFilter();
        List<Integer> positives = Arrays.asList(1, 2, 3, 10, 100, 1000, Integer.MAX_VALUE);
        List<Integer> notPositives = Arrays.asList(0, -1, -2, -3, -10, -100, -1000, Integer.MIN_VALUE);

        for (int n : positives)
            assertTrue(filter.accept(n));

        for (int n : notPositives)
            assertFalse(filter.accept(n));
    }
}
