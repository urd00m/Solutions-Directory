class Solution {
public:
    int minPartitions(string n) {
        // max digit 
        int max = 0; 
        for(char c : n) if((max = max > c-'0' ? max : c-'0') == 9) return max; 
        return max; 
    }
};
