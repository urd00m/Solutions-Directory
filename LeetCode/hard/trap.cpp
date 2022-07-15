class Solution {
public:
    int trap(vector<int>& height) {
        // calculate left max 
        if(height.size() <= 2) return 0; 
        
        // calculate left, right max 
        vector<int> left = vector(height.size(), 0);
        vector<int> right = vector(height.size(), 0);
        left[0] = height[0];
        right[height.size()-1] = height[height.size()-1];
        for(long i = 1; i < height.size(); i++) 
            left[i] = max(height[i], left[i-1]);
        for(long i = height.size()-2; i >= 0; i--)
            right[i] = max(height[i], right[i+1]); 
        
        // dp 
        int ret = 0; 
        for(long i = 0; i < height.size(); i++) {
            ret += min(left[i], right[i]) - height[i]; 
        }
        return ret; 
    }
};
