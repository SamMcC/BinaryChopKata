import java.util.Collection;

public class BinarySearcher {
    public int searchForValueInArray(int[] inputArray, int value) {
        int count = 0;
        for (Integer i : inputArray){
            if(value == i){
                return count;
            }
            count++;
        }
        return -1;
    }

    public int searchForValueInArrayBySplit(int[] inputArray, int value){
        float arrayLength = inputArray.length;
        float currentAttempt = 1;
        int currentIndex = (int) arrayLength-1;
        int result = -1;
        while (numberOfAttemptsIsLessThanLengthOfArray(currentAttempt, arrayLength, currentIndex)) {
            if (valueIsLessThanCurrentValue(inputArray[currentIndex], value)) {
                currentIndex -= Math.ceil(arrayLength / (currentAttempt * 2));
                currentIndex = correctIfTooHighOrTooLow(currentIndex, arrayLength);
            } else if (valueIsGreaterThanCurrentValue(inputArray[currentIndex], value)) {
                currentIndex += Math.ceil(arrayLength / (currentAttempt * 2));
                currentIndex = correctIfTooHighOrTooLow(currentIndex, arrayLength);
            }else{
                return currentIndex;
            }
            currentAttempt++;
        }

        return result;
    }
    public int searchForValueInArrayByRecursion(int[] inputArray, int value){
        int startIndex = 0;
        if(startIndex < inputArray.length) {
            return recurseOrReturn(inputArray, value, startIndex);
        }
        return -1;
    }

    private int searchForValueInArrayByRecursion(int[] inputArray, int value, int startIndex){
        if(startIndex < inputArray.length) {
            return recurseOrReturn(inputArray, value, startIndex);
        }
        return -1;
    }

    private int recurseOrReturn(int[] inputArray, int value, int startIndex) {
        if(inputArray[startIndex] == value){
            return startIndex;
        }else{
            return searchForValueInArrayByRecursion(inputArray, value, ++startIndex);
        }
    }

    private int correctIfTooHighOrTooLow(int currentIndex, float arrayLength) {
        if (currentIndex < 0){
            return 0;
        }else if(currentIndex > arrayLength-1){
            return (int) arrayLength-1;
        }else{
            return currentIndex;
        }
    }

    private boolean numberOfAttemptsIsLessThanLengthOfArray(float currentAttempt, float arrayLength, int currentIndex) {
        return currentAttempt <= arrayLength && arrayLength > 0 && currentIndex < arrayLength;
    }

    private boolean valueIsGreaterThanCurrentValue(int currentValue, int requiredValue) {
        return currentValue < requiredValue;
    }

    private boolean valueIsLessThanCurrentValue(int currentValue, int requiredValue) {
        return currentValue > requiredValue;
    }
}
