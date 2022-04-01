class Solution {
public:
    void reverseString(vector<char>& s) {
        long l = 0; 
        long r = s.size()-1; 
        while(l <= r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp; 
            l++;
            r--; 
        }
    }
};
