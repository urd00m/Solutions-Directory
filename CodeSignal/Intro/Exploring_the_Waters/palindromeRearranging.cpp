bool palindromeRearranging(string inputString) {
    //count each char
    vector<int> counts(26, 0); 
    for(char item : inputString) {
        counts[item-'a']++; 
    }
    
    //determine if there are any odds
    int odds = 0; 
    for(int item : counts) {
        if(item%2 == 1) odds++; 
    }
    
    if(inputString.size()%2 == 1 && odds == 1)
        return true;
    else if(inputString.size()%2 == 0 && odds == 0)
        return true; 
    else 
        return false;  
}

