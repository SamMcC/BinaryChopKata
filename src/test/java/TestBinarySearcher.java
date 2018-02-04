import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TestBinarySearcher {
    private BinarySearcher binarySearcher;
    private List<Integer> testArray = new ArrayList<>();

    @Before
    public void init(){
        binarySearcher = new BinarySearcher();
    }

    //TODO configure with JUnitParams instead since it'll be easier to fill out all of the test cases
    @Test
    public void testSearchForValueInArrayReturnsMinusOneForValueNotInArray(){
        int expected = -1;
        int value = 1;
        int actual = binarySearcher.searchForValueInArray(testArray, value);
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchForValueInArrayReturnsZeroForValueFirstInArray(){
        int expected = 0;
        int value = 1;
        testArray.add(1);
        int actual = binarySearcher.searchForValueInArray(testArray, value);
        assertEquals(expected, actual);
    }

}
