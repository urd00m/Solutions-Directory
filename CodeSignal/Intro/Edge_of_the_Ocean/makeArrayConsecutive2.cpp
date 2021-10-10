int makeArrayConsecutive2(vector<int> statues) {
    int min = INT_MAX; 
    int max = INT_MIN; 
    int inbetween_count = 0;
    for(int i = 0; i < statues.size(); i++) {
        min = min > statues[i] ? statues[i] : min; 
        max = max < statues[i] ? statues[i] : max; 
        inbetween_count++; 
    }
    
    if(statues.size() >= 2) {
        inbetween_count -= 2; 
    }
    else {
        return 0; 
    }
    
    return (max-min-1)-inbetween_count; 
    
}

