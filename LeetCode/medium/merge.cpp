class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int prefix[10001]{0}; 
        //count overlaps 
        vector<int> overlap; 
        for(vector<int> ary : intervals) {
            if(ary[0] == ary[1]) 
                overlap.push_back(ary[0]); 
            prefix[ary[0]]++; 
            prefix[ary[1]]--; 
        }
        
        //beging counting
        int cur = 0; 
        int start = -1; 
        vector<vector<int>> ret; 
        for(int i = 0; i < 10001; i++) {
            cur += prefix[i]; 
            if(start == -1 && cur != 0) {
                start = i; 
            }
            if(start != -1 && cur == 0) {
                ret.push_back({start, i}); 
                start = -1; 
                prefix[i] = 1; 
                continue; 
            }
            prefix[i] = cur; 
        }
        
        //add in overlaps
        for(int item : overlap) {
            if(prefix[item] == 0) {
                prefix[item] = 1; 
                ret.push_back({item, item});
            }
        }
        
        //return 
        return ret; 
    }
};
