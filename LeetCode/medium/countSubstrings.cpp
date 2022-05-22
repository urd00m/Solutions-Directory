class Solution {
public:
    int countSubstrings(string s) {
        // min is the si9ze of the string
        int ret = static_cast<int>(s.size()); 
        
        // determine palindromes brute force 
        for(int size = 2; size <= s.size(); size++) {
            for(long i = 0; i < s.size(); i++) {
                if(is_palin(s, i, size)) ret++;
            }
        }
        
        return ret;
    }
    
    bool is_palin(string& s, long i, int size) {
        if(i + size - 1 >= s.size()) return false; 
        long l = i;
        long r = i + size - 1; 
        while(l <= r) {
            if(s[l] != s[r]) return false; 
            l++; r--; 
        }
        return true; 
    }
};
