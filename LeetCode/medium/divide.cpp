#include <iostream>
#include <string>
class Solution {
public:
    int divide(int dividend, int divisor) {
        string ret = ""; 
        string cur_item = ""; 
        int dividend_multiplier = 1; 
        int divisor_multiplier = 1; 
        string sDividend = to_string(dividend);
        string sDivisor = to_string(divisor);
        if(dividend < 0) {
            dividend_multiplier = -1; 
            sDividend = sDividend.substr(1, sDividend.length()-1);
        }
        if(divisor < 0) {
            divisor_multiplier = -1;
            sDivisor = sDivisor.substr(1, sDivisor.length()-1);
        }

        for(unsigned long i = 0; i < sDividend.length(); i++) {
            cur_item = cur_item + to_string(sDividend[i]-'0'); 
            long temp_cur_item = stol(cur_item, nullptr, 10);
            long temp_sDivisor = stol(sDivisor, nullptr, 10); //can be moved 
            if(temp_cur_item < temp_sDivisor) {
                ret += "0"; 
                continue;   
            } 
            int temp_count = 0; 
            while(temp_cur_item >= temp_sDivisor) {
                temp_cur_item -= temp_sDivisor; 
                temp_count++; 
            }
            cur_item = to_string(temp_cur_item);
            ret = ret + to_string(temp_count); 
        }
        cout << ret << endl;
        //ret = reverse(ret); 
        if((dividend_multiplier < 0) ^ (divisor_multiplier < 0)) {
            return stoi("-"+ret);
        }
        if(ret == "2147483648") return INT_MAX;
        return stoi(ret);
    }
    
    string reverse(string a) {
        string ret = ""; 
        cout << a.length() << " " << a << endl;
        for(long i = a.length()-1; i >= 0; i--) {
            ret = ret + a.substr(i, 1); 
        }
        return ret; 
    }
};
