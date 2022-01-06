class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        //Sum up all the different times
        // if at any point it reaches more than capacity return false 
        vector<int> route(1001,0); 
        for(vector<int> trip : trips) {
            route[trip[1]] += trip[0]; 
            route[trip[2]] -= trip[0]; 
        }
        
        //Sum it up 
        int numPass = 0; 
        for(long i = 0; i < 1001; i++) {
            numPass += route[i]; 
            if(numPass > capacity) return false; 
        }
        
        return true; 
    }
};

//Less than 5 minutes 
