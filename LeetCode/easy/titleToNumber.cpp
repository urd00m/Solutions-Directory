class Solution {
public:
    int titleToNumber(string columnTitle) {
        int ret = 0;
        int power = columnTitle.length() - 1; 
        for(char &c : columnTitle) {
            ret += (c - 'A' + 1) * static_cast<int>(pow(26, power));
            power--; 
        }
        
        return ret; 
    }
};
