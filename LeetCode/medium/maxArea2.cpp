class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        // sort then calculate max 
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end()); 
        
        // find max distance 
        int prev = 0; 
        int maxH = 0; 
        for(long i = 0; i < horizontalCuts.size(); i++) {
            maxH = max(maxH, horizontalCuts[i] - prev); 
            prev = horizontalCuts[i]; 
        }
        maxH = max(maxH, h - prev); 
        
        prev = 0; 
        int maxV = 0; 
        for(long i = 0; i < verticalCuts.size(); i++) {
            maxV = max(maxV, verticalCuts[i] - prev); 
            prev = verticalCuts[i]; 
        }
        maxV = max(maxV, w - prev); 
        
        return (static_cast<long>(maxV) * maxH)%1000000007; 
    }
};
