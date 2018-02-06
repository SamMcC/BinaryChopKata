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
