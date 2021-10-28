int avoidObstacles(vector<int> inputArray) {
    //O(n^2)
    
    for(int i = 1; i < 1002; i++) {
        bool works = true;
        for(int item : inputArray) {
            if(item%i == 0) {
                works = false;
                break; 
            }  
        }
        if(works == true) return i; 
    }
    
    return -1; 
}

