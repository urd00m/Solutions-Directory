class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        // scan both 
        int w1 = 0, w2 = 0; 
        int i1 = 0, i2 = 0; 
        long n = word1.size(), m = word2.size(); 
        while(1) {
            if(i1 == word1[w1].size()) {i1 = 0; w1++;}
            if(i2 == word2[w2].size()) {i2 = 0; w2++;}
            
            if(w1 == n && w2 == m) return true; 
            else if(w1 == n || w2 == m) return false; // one is out of bounds 
            
            if(word1[w1][i1] != word2[w2][i2]) return false; 
            i1++; i2++; 
        }
    }
};
