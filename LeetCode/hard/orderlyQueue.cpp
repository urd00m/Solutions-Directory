#include <string.h>

class Solution {
public:
    string orderlyQueue(string s, int k) {
        // if k == s.size return the lexo smaller 
        // you can just sort if it is greater than oen since you can swap whenever you want 
        // for k == 1 you can just try all possible items and determine which one is the smallest one and return that one 
        string ret = s; 
        if(k > 1) {
            sort(ret.begin(), ret.end()); 
            return ret; 
        }
        else {
            string min_ret = ret; 
            for(int i = 1; i < ret.size(); i++) {
                ret += string(1, ret[0]); 
                ret.erase(0, 1); 
                if(strcmp(ret.c_str(), min_ret.c_str()) < 0) min_ret = ret; 
            }
            return min_ret; 
        }
    }
};
