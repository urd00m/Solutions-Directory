class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        vector<int> m = vector(26, 0); 
        for(int i = 0; i < order.size(); i++) 
            m[order[i] - 'a'] = 'a' + i; 
        
        // there are much better ways of doing this but i'm lazy 
        vector<string> n; 
        for(string& word : words) {
            string add = "";
            for(int i = 0; i < word.size(); i++) add += string(1, m[word[i] - 'a']); 
            n.push_back(add); 
        }

        // copy 
        vector<string> n2 = n; 
        sort(n2.begin(), n2.end()); 
        for(int i = 0; i < n.size(); i++) {
            if(n2[i] != n[i]) return false;
        }
        return true; 
    }
};
