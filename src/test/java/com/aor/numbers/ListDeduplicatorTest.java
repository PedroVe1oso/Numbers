package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    private List<Integer> list;

    @BeforeEach
    private void helper(){
        list = Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void deduplicate() {

        class StubGenericListSorter implements GenericListSorter{
            @Override
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,4,5);
            }
        }

        List<Integer> expected = Arrays.asList(1,2,4,5);

        GenericListSorter listSorter = new StubGenericListSorter();

        GenericListDeduplicator deduplicator = new ListDeduplicator(listSorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug_8726() {

        class StubGenericListSorter implements GenericListSorter{
            @Override
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,4);
            }
        }

        GenericListSorter listSorter = new StubGenericListSorter();

        ListDeduplicator deduplicator = new ListDeduplicator(listSorter);
        List<Integer> distinct = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2));

        Assertions.assertEquals(Arrays.asList(1, 2, 4), distinct);
    }
}

