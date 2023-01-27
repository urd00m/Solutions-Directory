class Solution {
public:
    bool dfs(string& w, unordered_set<string>& m) { 
        for(int i = 1; i <= w.size(); i++) {
            string p = w.substr(0, i);
            string s = w.substr(i, w.size()-i);
            if(m.find(p) != m.end() && (m.find(s) != m.end() || dfs(s, m))) return true; 
        }
        return false; 
    }

    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        unordered_set<string> m; 
        for(string& word : words) m.insert(word); 

        // recursion? 
        vector<string> ret; 
        for(string& word : words) {
            if(dfs(word, m)) ret.push_back(word); 
        }
        return ret; 
    }
};
