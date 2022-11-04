class Solution {
public:
    bool is_vowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'); 
    }

    string reverseVowels(string s) {
        string ret = s; 
        long l = 0, r = ret.size() - 1; 
        while(l < r) {
            if(is_vowel(ret[l]) == false) l++;
            if(is_vowel(ret[r]) == false) r--;

            if(is_vowel(ret[l]) && is_vowel(ret[r])) {
                char temp = ret[l]; 
                ret[l] = ret[r];
                ret[r] = temp;
                l++; r--;  
            }
        }
        return ret; 
    }
};
