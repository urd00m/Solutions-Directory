class Solution {
public:
    vector<string> ret; 
    long n; 
    vector<string> letterCombinations(string digits) {
        Solution::n = digits.length();
        
        if(digits.length() == 0) return {}; 
        recur(digits, 0, ""); 
        return ret; 
    }
    
    void recur(string digits, int depth, string cur) { //depth < n
        if(depth == n) { //base case
            Solution::ret.push_back(cur);
        }
        else {
            if(digits[depth] == '2') {
                recur(digits, depth+1, cur+"a");
                recur(digits, depth+1, cur+"b");
                recur(digits, depth+1, cur+"c");
            }
            else if(digits[depth] == '3') {
                recur(digits, depth+1, cur+"d");
                recur(digits, depth+1, cur+"e");
                recur(digits, depth+1, cur+"f");
            }
            else if(digits[depth] == '4') {
                recur(digits, depth+1, cur+"g");
                recur(digits, depth+1, cur+"h");
                recur(digits, depth+1, cur+"i");
            }
            else if(digits[depth] == '5') {
                recur(digits, depth+1, cur+"j");
                recur(digits, depth+1, cur+"k");
                recur(digits, depth+1, cur+"l");
            }
            else if(digits[depth] == '6') {
                recur(digits, depth+1, cur+"m");
                recur(digits, depth+1, cur+"n");
                recur(digits, depth+1, cur+"o");
            }
            else if(digits[depth] == '7') {
                recur(digits, depth+1, cur+"p");
                recur(digits, depth+1, cur+"q");
                recur(digits, depth+1, cur+"r");
                recur(digits, depth+1, cur+"s");
            }
            else if(digits[depth] == '8') {
                recur(digits, depth+1, cur+"t");
                recur(digits, depth+1, cur+"u");
                recur(digits, depth+1, cur+"v");
            }
            else if(digits[depth] == '9') {
                recur(digits, depth+1, cur+"w");
                recur(digits, depth+1, cur+"x");
                recur(digits, depth+1, cur+"y");
                recur(digits, depth+1, cur+"z");
            }
        }
    }
};
