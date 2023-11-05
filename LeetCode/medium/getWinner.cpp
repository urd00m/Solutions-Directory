class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        // simulation 
        int ret = arr[0];
        int win_count = 0; 
        int ptr = 1; 
        while(ptr < arr.size()) {
            if(arr[ptr] > ret) {
                win_count = 1;
                ret = arr[ptr]; 
            }
            else win_count++; 

            if(win_count == k) break; 

            ptr++; 
        }
        return ret; 
    }
};
