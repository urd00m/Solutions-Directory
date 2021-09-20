class Solution {
public:
    int maxArea(vector<int>& height) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        unsigned long l = 0; unsigned long r = height.size()-1; 
        long max = 0; 
        while(l < r) {
            if(height[l] > height[r]) {
                max = (r-l)*height[r] > max ? (r-l)*height[r] : max; 
                r--;
            }
            else {
                max = (r-l)*height[l] > max ? (r-l)*height[l] : max; 
                l++; 
            }
        }
        return max; 
    }
};
