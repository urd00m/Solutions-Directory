class Solution {
public:
    
    int dist(int a, int b) {
        return abs(a - b); 
    }
    
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> ret; 
        int count = 0; 
        int l = -1, r = -1; 
        for(int i = 0; i < arr.size(); i++)
            if(arr[i] >= x) {
                r = i; 
                l = i - 1;
                break;
            }
        if(r == -1) {
            l = arr.size()-1; 
            r = arr.size(); 
        }
        
        
        while(count < k) {
            int a_dist = INT32_MAX;
            int b_dist = INT32_MAX; 
            if(l >= 0) a_dist = dist(x, arr[l]); 
            if(r < arr.size()) b_dist = dist(x, arr[r]);
            if(a_dist <= b_dist) 
                ret.push_back(arr[l--]); 
            else 
                ret.push_back(arr[r++]);
            count++; 
        }
        
        sort(ret.begin(), ret.end());
        return ret; 
    }
};
