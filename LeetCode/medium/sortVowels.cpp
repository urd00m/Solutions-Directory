class Solution {
public:
    string sortVowels(string s) {
        string ret = s; 
        vector<char> v; 
        for(char c : s) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                v.push_back(c);
        }
        sort(v.begin(), v.end()); 
        int v_pos = 0; 
        for(int i = 0; i < ret.size(); i++) {
            char c = ret[i]; 
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                ret[i] = v[v_pos++]; 
        }
        return ret; 
    }
};
