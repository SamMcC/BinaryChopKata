import java.util.List;

public class BinarySearcher {
    public int searchForValueInArray(List<Integer> testArray, int value) {
        for (Integer i : testArray){
            if(value == i){
                return testArray.indexOf(i);
            }
        }
        return -1;
    }
}
