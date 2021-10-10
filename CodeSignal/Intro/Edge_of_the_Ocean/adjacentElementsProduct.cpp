int adjacentElementsProduct(int[] inputArray) {
    int max = Integer.MIN_VALUE; 
    for(int i = 0; i < inputArray.length-1; i++) {
        max = Math.max(max, inputArray[i]*inputArray[i+1]);
    }
    return max; 
}

