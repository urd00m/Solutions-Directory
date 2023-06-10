class Solution {
public:
    long long sum(int n, int s) {
        return (s <= n ? (s*(s+1L))/2 + (n-s) : (n/2.0)*(2*s + (n-1)*-1));
    }

    int maxValue(int n, int index, int maxSum) {
        // side legnths L: (index) R: (n - index)
        // index -> x 
        // decrease by 1 each time in a pyramid style 
        // want sum(arr) to be as good as possible (need to converge binary search?)
        // bin search 
        // given guess m
        // sum = 
        // arthmetic sequence sum = (n/2)(2a + (n-1)d)
        int l = 0; 
        int r = 1000000000;
        while(l < r) {
            int m = (l+r+1)/2; 

            // calc sum
            long long s = sum(index, m-1) + sum(n - index - 1, m-1) + m; 
            if(maxSum == s) return m;
            else if(s < maxSum) l = m; 
            else r = m-1; 
        }
        return l; 
    }
};

// 2 1 0 0 
