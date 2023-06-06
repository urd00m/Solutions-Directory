class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {
        sort(arr.begin(), arr.end()); 

        // start 
        int c = arr[1] - arr[0]; 
        for(int i = 1; i < arr.size(); i++) 
            if(arr[i] - arr[i-1] != c) return false;
        return true; 
    }
};
