class Solution {
public:
    int removePalindromeSub(string s) {
        //palindrome check
        // the subsequence doesn't need to be contingous 
        long i = 0, j = s.size()-1; 
        while(i < j) {
            if(s[i] != s[j]) return 2; 
            i++;
            j--; 
        }
        return 1; // is palindrome 
    }
};
