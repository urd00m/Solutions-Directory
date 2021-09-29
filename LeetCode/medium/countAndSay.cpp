class Solution {
public:
    string countAndSay(int n) {
            return recur(n);
    }
    
    string recur(int n) {
        if(n == 1) {
            return "1"; 
        }
        else return say(recur(n-1));
    }
    
    string say(string item) {
        char cur = ' ';
        int count = 0; 
        string ret = ""; 
        for(unsigned long i = 0; i < item.length(); i++) {
            if(cur == ' ' || cur == item[i]) {
                cur = item[i];
                count++;
            }
            else {
                ret += to_string(count)+string(1, cur); 
                cur = item[i];
                count = 1; 
            }
        }
        ret += to_string(count)+string(1, cur); 
        return ret; 
    }
};
