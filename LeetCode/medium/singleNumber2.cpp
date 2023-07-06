class Solution {
public:
    int singleNumber(vector<int>& nums) {
        // count the bits 
        vector<int> d = vector(32, 0); 
        for(int item : nums)
            for(int i = 0; i < 32; i++) 
                if(item & (1<<i)) d[i]++; 

        // ret 
        int ret = 0; 
        for(int i = 0; i < 32; i++) 
            if(d[i] % 3) 
                ret += (1<<i); 
        return ret; 
    }
};
