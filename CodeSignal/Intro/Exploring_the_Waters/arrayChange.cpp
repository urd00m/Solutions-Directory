int arrayChange(vector<int> inputArray) {
    int change = 0; 
    for(long i = 1; i < inputArray.size(); i++) {
        int prev = inputArray[i-1];
        int cur = inputArray[i];
        if(cur > prev) continue; 
        change += (prev+1)-cur; 
        inputArray[i] += (prev+1)-cur; 
    }
    
    return change; 
}

