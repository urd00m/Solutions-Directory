class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        // find max
        int m = 0; 
        for(int c : candies) m = max(m, c); 

        // iterate
        vector<bool> ret;
        for(int c : candies)
            if(c + extraCandies >= m) ret.push_back(true);
            else ret.push_back(false); 
        return ret; 
    }
};
