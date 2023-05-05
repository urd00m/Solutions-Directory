#define VOWELS(i, size) (p[i+size]-p[i])

class Solution {
public:
    int maxVowels(string s, int k) {
        // preprocess
        size_t n = s.size(); 
        vector<int> p = vector(n+1, 0); 

        // prefix sum 
        for(size_t i = 1; i <= n; i++) {
            char c = s[i-1]; 
            p[i] += p[i-1]; 
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                p[i] += 1; 
        }

        // calculate 
        int ret = 0; 
        for(size_t i = 0; i < n-k+1; i++)
            ret = max(ret, VOWELS(i, k)); 
        return ret; 
    }
};
