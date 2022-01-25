class Solution {
public:
    bool validMountainArray(vector<int>& arr) {
        if(arr.size() < 3)  return false; 
        
        //go strictly increasing 
        long i = 1; 
        for(; i < arr.size(); i++) {
            if(arr[i-1] == arr[i]) return false; 
            else if(arr[i-1] > arr[i]) break; 
        }
        if(i == arr.size() || i == 1) return false; 
        
        
        // go strictly decreasing 
        for(; i < arr.size(); i++) {
            if(arr[i-1] == arr[i]) return false; 
            else if(arr[i-1] < arr[i]) return false; ; 
        }
        
        return true; 
    }
};
