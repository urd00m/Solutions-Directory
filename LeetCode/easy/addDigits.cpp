class Solution {
public:
    int addDigits(int num) {
        string digits = to_string(num); 
        while(digits.length() > 1) {
            int sum = 0; 
            for(char c : digits) {
                sum += (c-'0'); 
            }
            digits = to_string(sum);
        }
        
        return stoi(digits);
    }
};
