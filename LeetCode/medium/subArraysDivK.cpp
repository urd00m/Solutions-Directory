class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        // 4 5 0 -2 -3 1  k = 5 
        // 4 9 9  7 4  5
        // 4 4 4 2  4 

        // [2,-2,2,-4] k = 6
        // 2 0 2 -2
        // 2 0 2 


        // 1 + 2 + 3 + 1 = 7 
        
        // prefix sum to make subarray sum counting easy 
        // map the mods allowing for O(1) lok up for pairs 
        int sum = 0; 
        vector<int> pref; 
        for(int num : nums) {
            sum += num; 
            pref.push_back(sum); 
        }

        // iterate
        unordered_map<int, int> m; 
        int ret = 0; 
        for(int p : pref) { 
            int mod = (p%k + k)%k;
            if(mod == 0) ret++; 
            if(m.find(mod) == m.end()) m[mod] = 0; 
            ret += m[mod]++; 
        }

        return ret; 
    }
};
