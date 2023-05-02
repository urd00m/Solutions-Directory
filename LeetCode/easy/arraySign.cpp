class Solution {
public:
    int arraySign(vector<int>& nums) {
        bool p = true; 
        for(int i : nums)
            if(i == 0) return 0; 
            else if(i < 0) p = !p; 
        return (p == true ? 1 : -1); 
    }
};
