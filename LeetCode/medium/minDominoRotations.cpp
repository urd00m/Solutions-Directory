class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        // base check 
        if(tops.size() <= 1) return 0; 
        
        // iterate through and determine which values can be used 
        vector<int> posValues(2, -1); 
        posValues[0] = tops[0];
        if(bottoms[0] != tops[0]) posValues[1] = bottoms[0];
        for(long i = 1; i < tops.size(); i++) {
            bool topin = in(tops[i], posValues); 
            bool bottomin = in(bottoms[i], posValues);
            posValues[0] = -1; posValues[1] = -1; 
            if(topin) {
                posValues[0] = tops[i]; 
            }
            if(bottomin && bottoms[i] != tops[i]) {
                posValues[1] = bottoms[i];
            }
            if(topin == false && bottomin == false) {
                return -1; //not possible  
            }
        }
        
        //iterate through and count swaps
        int minSwaps = INT32_MAX; 
        for(int value : posValues) {
            if(value == -1) continue; 
            
            //top 
            int swaps = 0; 
            for(long i = 0; i < tops.size(); i++) {
                if(tops[i] != value) swaps++; 
            }
            if(swaps < minSwaps) minSwaps = swaps;

            //bottom
            swaps = 0;
            for(long i = 0; i < tops.size(); i++) {
                if(bottoms[i] != value) swaps++; 
            }
            if(swaps < minSwaps) minSwaps = swaps;
        }
        return minSwaps; 
    }
    
    bool in(int item, vector<int>& a) {
        for(int temp : a) {
            if(item == temp) return true;
        }
        return false; 
    }
};
