class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        long n = matrix.size(); 
        int low = matrix[0][0]; 
        int high = matrix[n-1][n-1]; 
        
        while(low < high) {
            int mid = low + (high-low)/2; 
            int count = 0; 
            
            // count number of elements that are less than number mid 
            for(long i = 0; i < n; i++) {
                int temp = n-1; 
                while(temp >= 0 && matrix[i][temp] > mid) temp--; 
                count += temp+1; 
            }
            
            if(count < k) low = mid+1; 
            else high = mid; 
        }
        return low; 
    }
};
