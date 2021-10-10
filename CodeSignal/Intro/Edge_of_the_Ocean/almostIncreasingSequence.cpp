#include <vector>
#include <cassert>
#include <iostream>
#include <stdio.h>

int findBadSequence(vector<int> a); 

bool almostIncreasingSequence(vector<int> sequence) {
    int first = findBadSequence(sequence); 
    if(first == -1) return true; 
    else{ 
        int temp = sequence[first]; 
        
        sequence.erase(sequence.begin()+first); 
        int status = findBadSequence(sequence); 
        
        sequence.insert(sequence.begin()+first, temp); 
        
        sequence.erase(sequence.begin()+first+1); 
        int status2 = findBadSequence(sequence); 
        
        if(status != -1 && status2 != -1) return false; 
        return true; 
    }
}

// Returns location of the bad pair [i, i+1] is the bad pair, -1 if there isn't one 
int findBadSequence(vector<int> a) {
    for(unsigned long i = 0; i < a.size()-1; i++) {
        if(a[i] >= a[i+1]) return i; 
    }
    return -1; 
}

