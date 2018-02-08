import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearcher {
    public int searchForValueInArrayByLoop(int[] inputArray, int value) {
        int count = 0;
        for (Integer i : inputArray){
            if(valueIsGreaterThanCurrentValue(value, inputArray[count])){
                return -1;
            }
            if(value == i){
                return count;
            }
            count++;
        }
        return -1;
    }

    public int searchForValueInArrayByAdaptiveSearch(int[] inputArray, int value){
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

    public int searchForValueInArrayByRandomWalk(int[] inputArray, int value){
        int arrayLength = inputArray.length;
        List<Integer> arrayOfGuesses = getListOfIndices(arrayLength);
        for (int i : arrayOfGuesses){
            if (inputArray[i] == value){
                return i;
            }
        }
        return -1;
    }

    public int searchForValueInArrayByRecursiveChop(int[]inputArray, int value){
        int arrayLength = inputArray.length;
        if (arrayLength == 0 || inputArray[0] > value || inputArray[arrayLength-1] < value){
            return -1;
        }
        if(inputArray[0] == value){
            return 0;
        }


        int halfArrayIndex = arrayLength/2;

        int[] firstHalfOfArray = new int[halfArrayIndex];
        int[] secondHalfOfArray = new int[arrayLength - halfArrayIndex];
        System.arraycopy(inputArray, 0, firstHalfOfArray, 0, firstHalfOfArray.length);
        for (int i = 0; i < secondHalfOfArray.length; i++){
            secondHalfOfArray[i] = inputArray[i+halfArrayIndex];
        } // System.arrayCopy doesn't work on this half for some reason, seriously, I spent about an hour testing it.

        int outputValue;
        if(inputArray[halfArrayIndex] > value){
            outputValue = searchForValueInArrayByAdaptiveSearch(firstHalfOfArray, value);
        }else{
            int newValue;
            newValue = searchForValueInArrayByAdaptiveSearch(secondHalfOfArray, value);
            if (newValue != -1){
                outputValue = halfArrayIndex + newValue;
            }else{
                return -1;
            }
        }
        return outputValue;
    }

    private List<Integer> getListOfIndices(int arrayLength) {
        List<Integer> arrayOfGuesses = new ArrayList<>();
        for (int i = 0; i<arrayLength; i++){
            arrayOfGuesses.add(i);
        }
        Collections.shuffle(arrayOfGuesses);
        return arrayOfGuesses;
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
