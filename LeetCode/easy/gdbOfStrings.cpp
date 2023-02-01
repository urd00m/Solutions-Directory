class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        string cur = "";
        string ret = "";
        for(int i = 0; i < min(str1.size(), str2.size()); i++) {
            if(str1[i] != str2[i]) break; 
            cur += string(1, str1[i]); 

            // check to ensure it works 
            bool good = true; 
            if(str1.size() % cur.size() != 0 || str2.size() % cur.size() != 0) continue; 
            for(int j = 0; j < str1.size()/cur.size(); j++) {
                if(str1.substr(j*cur.size(), cur.size()) != cur) {
                    good = false;
                    break;
                }
            }
            for(int j = 0; j < str2.size()/cur.size(); j++) {
                if(str2.substr(j*cur.size(), cur.size()) != cur) {
                    good = false;
                    break;
                }
            }
            if(good) ret = cur; 
        }
        return ret;
    }
};
