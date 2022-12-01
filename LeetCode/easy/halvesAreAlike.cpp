class Solution {
public:
    bool halvesAreAlike(string s) {
        int half = s.size()/2; 
        vector<char> vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}; 
        unordered_map<char, int> half1, half2; 
        for(int i = 0; i < half; i++) {
            if(half1.find(s[i]) == half1.end()) 
                half1[s[i]] = 0;
            half1[s[i]]++; 
        }
        for(int i = half; i < s.size(); i++) {
            if(half2.find(s[i]) == half2.end()) 
                half2[s[i]] = 0;
            half2[s[i]]++; 
        }

        int c1 = 0, c2 = 0; 
        for(char vowel : vowels) {
            if(half1.find(vowel) != half1.end()) c1 += half1[vowel];
            if(half2.find(vowel) != half2.end()) c2 += half2[vowel];
        }
        if(c1 == c2) return true; 
        else return false; 
    }
};
