vector<int> sortByHeight(vector<int> a) {
    //insertion sort 
    for(unsigned long i = 0; i < a.size(); i++) {
        int min = a[i]; 
        int min_loc = i; 
        if(a[i] == -1) continue; 
        for(unsigned long j = i+1; j < a.size(); j++) {
            if(a[j] == -1) continue; 
            if(a[j] < min) {
                min = a[j]; 
                min_loc = j; 
            }
        }
        //perform a swap 
        int temp = a[i]; 
        a[i] = a[min_loc];
        a[min_loc] = temp; 
    }
    
    return a; 
}

