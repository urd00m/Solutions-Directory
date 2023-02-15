class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        vector<int> ret = num; 
        int i = ret.size() - 1; 
        int carry = k; 
        while(i >= 0 && carry > 0) {
            int sum = num[i] + carry; 
            ret[i] = sum%10; 
            carry = sum/10;
            i--; 
        }
        while(carry > 0) {
            ret.insert(ret.begin(), carry%10); 
            carry /= 10; 
        }
        return ret; 
    }
};
