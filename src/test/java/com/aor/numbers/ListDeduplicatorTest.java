package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    private List<Integer> list;
    private List<Integer> expected;

    @BeforeEach
    private void helper(){
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }

    @Test
    public void deduplicate() {

        GenericListSorter listSorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(listSorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4, 5));

        GenericListDeduplicator deduplicator = new ListDeduplicator(listSorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug_8726() {

        GenericListSorter listSorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(listSorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));

        GenericListDeduplicator deduplicator = new ListDeduplicator(listSorter);
        List<Integer> distinct = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2));

        Assertions.assertEquals(Arrays.asList(1, 2, 4), distinct);
    }
}

