class Solution {
public:
    int countVowelStrings(int n) {
        // Pattern 
        int a = 1; 
        int e = 1; 
        int i = 1; 
        int o = 1; 
        int u = 1; 
        
        for (int j = 2; j <= n; j++) {
            a = a+e+i+o+u;
            e = e+i+o+u;
            i = i+o+u;
            o = o+u; 
            u = u; 
        }
        
        return a+e+i+o+u; 
    }
};o

