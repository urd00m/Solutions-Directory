class Solution {
public:
    int trailingZeroes(int n) {
        int count = 0; 
        for(int i = 0; i <= n; i++) {
            if(i != 0 && i % 5 == 0) { 
                count += count5s(i); 
            }
        }
        return count; 
    }
    
    //count 5s 
    int count5s(int num) {
        int count = 0; 
        while(num % 5 == 0) {
            num = num / 5; 
            count ++; 
        }
        return count; 
    }
};
