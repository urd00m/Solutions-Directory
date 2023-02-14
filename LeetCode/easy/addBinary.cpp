class Solution {
public:
    string addBinary(string a, string b) {
        int i = a.size()-1; 
        int j = b.size()-1; 
        int carry = 0; 
        string ret = ""; 
        while(i >= 0 || j >= 0) {
            int sum = 0; 
            if(i >= 0 && a[i] == '1') sum++; 
            if(j >= 0 && b[j] == '1') sum++; 
            sum += carry; carry = 0; 
            if(sum >= 2) {
                carry = 1; 
                sum -= 2; 
            }
            if(sum) ret+="1";
            else ret+="0"; 
            i--; j--;
        }
        if(carry) ret+="1"; 

        // reverse string 
        reverse(ret.begin(), ret.end()); 
        return ret; 
    }
};
