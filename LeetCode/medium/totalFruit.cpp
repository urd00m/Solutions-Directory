class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        if(fruits.size() <= 2) return fruits.size(); 
        // two pointers? 
        int l = 0; int r = 1;
        int basket1 = fruits[0], basket2 = -1; 
        int n1 = 1, n2 = 0; 
        int ret = 0; 
        while(r < fruits.size()) {
            // pick r 
            int cur = fruits[r]; 
            if(basket1 == cur) n1++; 
            else if(basket2 == cur) n2++; 
            else {
                // keep increasing l 
                while(n1 > 0 && n2 > 0) {
                    if(fruits[l++] == basket1) n1--; 
                    else n2--; 
                }
                if(n1 == 0) {
                    basket1 = cur;
                    n1 = 1; 
                } else {    
                    basket2 = cur; 
                    n2 = 1; 
                }
            }
            r++; 
            ret = max(ret, n1+n2); 
        } 
        return ret; 
    }
};
