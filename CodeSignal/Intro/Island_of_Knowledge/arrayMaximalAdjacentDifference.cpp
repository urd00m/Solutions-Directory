int arrayMaximalAdjacentDifference(vector<int> inputArray) {
    int ret = -1; 
    for(long i = 1; i < inputArray.size(); i++) {
        ret = max(ret, abs(inputArray[i]-inputArray[i-1]));
    }
    return ret; 
}

