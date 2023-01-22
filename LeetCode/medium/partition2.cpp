class Solution {
public:
    bool is_palin(string& s) {
        int i = 0, j = s.size() - 1; 
        while(i <= j) {
            if(s[i] != s[j]) return false; 
            i++; j--; 
        }
        return true; 
    }

    void dfs(int idx, string& s, vector<string>& back, vector<vector<string>>& ret) {
        if(idx == s.size()) {
            ret.push_back(back);
            return; 
        }

        // visit all possible sections
        string cur = ""; 
        for(int i = idx; i < s.size(); i++) {
            cur += string(1, s[i]); 
            if(is_palin(cur)) {
                back.push_back(cur);
                dfs(i+1, s, back, ret); 
                back.pop_back(); 
            }
        }
    }


    vector<vector<string>> partition(string s) {
        // DFS 
        vector<vector<string>> ret; 
        vector<string> back; 
        dfs(0, s, back, ret);
        return ret;
    }
};
