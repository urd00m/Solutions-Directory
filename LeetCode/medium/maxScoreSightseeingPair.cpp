class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        // dp    - 8 11 11 10 
        // max   7 7 6 5 4 5
        // O(n) solution 
        // maintain the max pair value we wish to return 
        // also maintain the max value we have found 
        // at each turn we decrement max, check the max pair value, then reset the max value to the value we want 
        
        // get initial pair value
        int ret = values[0]+values[1]-1; 
        int maxvalue = 0; 
        if(values[0] > values[1]) maxvalue=values[0]-2;
        else maxvalue = values[1]-1; 
        
        // dp 
        for(long i = 2; i < values.size(); i++) {
            ret = max(ret, maxvalue--+values[i]); 
            maxvalue = max(maxvalue, values[i]-1); 
        }
        return ret; 
    }
};
