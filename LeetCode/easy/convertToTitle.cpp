class Solution {
public:
    string convertToTitle(int columnNumber) {
        // base 26 language 
        string ret = ""; 
        while(columnNumber > 0) {
            ret += 'A' + ((columnNumber - 1) % 26);
            columnNumber = (columnNumber - 1) / 26;
        }
        reverse(ret.begin(), ret.end());
        return ret; 
    }
};
