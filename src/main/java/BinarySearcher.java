public class BinarySearcher {
    public int searchForValueInArray(int[] testArray, int value) {
        int count = 0;
        for (Integer i : testArray){
            if(value == i){
                return count;
            }
            count++;
        }
        return -1;
    }
}
