#define END 10000

class Solution {
public:
    bool checkAndGrab(int start, int size, string& s, string& ret) {
        if(start >= s.size()) return false; 
        ret = s.substr(start, size);
        if(ret.size() < 1 || ret.size() > 3) return false; 
        int retv = stoi(ret);
        if(retv > 255 || retv < 0) return false ; 
        else if( (retv != 0 && ret[0] == '0') || (retv == 0 && ret.size() > 1)) return false; // no leading zeroes
        return true; 
    }

    vector<string> restoreIpAddresses(string s) {
        // brute force
        // simulate 3 dots 
        vector<string> ret;
        for(int i = 1; i <= 3; i++) {
            // check if first section valid 
            string a; 
            if(!checkAndGrab(0, i, s, a)) continue; 
            for(int j = 1; j <= 3; j++) {
                string b; 
                if(!checkAndGrab(i, j, s, b)) continue;
                for(int k = 1; k <= 3; k++) {
                    string c, d; 
                    if(!checkAndGrab(i+j, k, s, c)) continue;
                    if(!checkAndGrab(i+j+k, END, s, d)) continue;

                    string v = a + "." + b + "." + c + "." + d; 
                    ret.push_back(v); 
                }
            }
        }
        return ret;
    }
};
