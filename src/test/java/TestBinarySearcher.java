import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TestBinarySearcher {
    private BinarySearcher binarySearcher;

    @Before
    public void init() {
        binarySearcher = new BinarySearcher();
    }

    @Test
    @Parameters(method = "parametersForValueNotInArray")
    public void testSearchForValueInArrayReturnsMinusOneForValueNotInArray(int[] testArray,
                                                                           int value) {
        int expected = -1;
        int actual = binarySearcher.searchForValueInArray(testArray, value);
        assertEquals(expected, actual);
    }

    @Test
    @Parameters(method = "parametersForValueInArray")
    public void testSearchForValueInArrayReturnsLocationOfValueInArray(int[] testArray,
                                                                       int value,
                                                                       int expected) {
        int actual = binarySearcher.searchForValueInArray(testArray, value);
        assertEquals(expected, actual);
    }

    @Test
    @Parameters(method = "parametersForValueNotInArray")
    public void testSearchForValueBySplitReturnsMinusOneForValueNotInArray(int[] testArray,
                                                                           int value) {
        int expected = -1;
        int actual = binarySearcher.searchForValueInArrayBySplit(testArray, value);
        assertEquals(expected, actual);
    }

    @Test
    @Parameters(method = "parametersForValueInArray")
    public void testSearchForValueBySplitReturnsLocationOfValueInArray(int[] testArray,
                                                                       int value,
                                                                       int expected) {
        int actual = binarySearcher.searchForValueInArrayBySplit(testArray, value);
        assertEquals(expected, actual);
    }

    @Test
    @Parameters(method = "parametersForValueNotInArray")
    public void testSearchForValueByRecursionReturnsMinusOneForValueNotInArray(int[] testArray,
                                                                           int value) {
        int expected = -1;
        int actual = binarySearcher.searchForValueInArrayByRecursion(testArray, value);
        assertEquals(expected, actual);
    }

    @Test
    @Parameters(method = "parametersForValueInArray")
    public void testSearchForValueByRecursionReturnsLocationOfValueInArray(int[] testArray,
                                                                       int value,
                                                                       int expected) {
        int actual = binarySearcher.searchForValueInArrayByRecursion(testArray, value);
        assertEquals(expected, actual);
    }

    private Object[] parametersForValueNotInArray() {
        int[] i = {};
        int[] j = {1};
        int[] k = {1, 3, 5};
        int[] l = {1, 3, 5, 7};
        return new Object[]{
                new Object[]{i, 1},
                new Object[]{j, 3},
                new Object[]{k, 0},
                new Object[]{k, 2},
                new Object[]{k, 4},
                new Object[]{k, 6},
                new Object[]{l, 0},
                new Object[]{l, 2},
                new Object[]{l, 4},
                new Object[]{l, 6},
                new Object[]{l, 8}
        };
    }

    private Object[] parametersForValueInArray() {
        int[] j = {1};
        int[] k = {1, 3, 5};
        int[] l = {1, 3, 5, 7};
        return new Object[]{
                new Object[]{j, 1, 0},
                new Object[]{k, 1, 0},
                new Object[]{k, 3, 1},
                new Object[]{k, 5, 2},
                new Object[]{l, 1, 0},
                new Object[]{l, 3, 1},
                new Object[]{l, 5, 2},
                new Object[]{l, 7, 3}
        };
    }
}
