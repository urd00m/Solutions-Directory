class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        bool s = true; 
        int i = 0, j = 0; 
        string ret = ""; 
        while(i < word1.size() && j < word2.size()) {
            if(s) ret += string(1, word1[i++]);
            else ret += string(1, word2[j++]); 
            s = !s; 
        }
        if(i < word1.size()) ret += word1.substr(i, string::npos); 
        if(j < word2.size()) ret += word2.substr(j, string::npos); 
        return ret;
    }
};
