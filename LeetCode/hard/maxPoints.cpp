class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        // O(n^2) brute force   
        // just start from one point and look at its slope to every other point and maintain 
        // a mapping with the count
        int ret = 1; 
        for(vector<int>& p1 : points) {
            unordered_map<double, int> m; 
            for(vector<int>& p2 : points) { 
                if(p1 == p2) continue; 
                
                // calculate slope 
                double slope; 
                int ydiff = p2[1] - p1[1]; 
                int xdiff = p2[0] - p1[0]; 
                if(xdiff == 0) 
                    slope = DBL_MAX; 
                else 
                    slope = (double)ydiff / (double)xdiff; 

                // calculate max 
                m[slope]++; 
                ret = max(ret, m[slope]+1); 
            }
        }
        return ret; 
    }
};
