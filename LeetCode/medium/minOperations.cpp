class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        // prefix sum on both sides and just scan 
        unordered_map<int, int> m;
        int s = 0;
        for(int i = nums.size()-1; i >= 0; i--) 
            m[(s += nums[i])] = (nums.size() - i); 
        if(s < x) return -1; 

        // scan 
        int ret = -1; 
        int p = 0; 
        if(m.find(x) != m.end()) ret = m[x]; 
        for(int i = 0; i < nums.size(); i++) {
            p += nums[i]; 

            // cases 
            if(p > x) break; 
            else if(p == x) ret = (ret == -1 ? i + 1 : min(ret, i+1)); 
            else if( m.find(x - p) != m.end() ) {
                if(ret == -1 || (m[x - p] + (i+1)) < ret) 
                    ret = m[x - p] + (i+1); 
            }
        }
        return ret; 
    }
};
