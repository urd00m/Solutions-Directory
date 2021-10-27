class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        long n = matrix.size();
        long m = matrix[0].size(); 
        //find row 
        long l = 0; long r = n-1; long mid; 
        while(l <= r) {
            mid = (l+r)/2; 
            
            if(matrix[mid][0] <= target && matrix[mid][m-1] >= target) break; 
            
            if(matrix[mid][0] < target) {
                l = mid+1; 
            } 
            else {
                r = mid-1; 
            }
        }

        //mid should contain correct value 
        if(!(matrix[mid][0] <= target && matrix[mid][m-1] >= target)) return false; //not correct one 
        
        //find col 
        long row = mid; 
        l = 0; r = m-1;
        while(l <= r) {
            mid = (l+r)/2; 
            
            if(matrix[row][mid] == target) return true; 
            
            if(matrix[row][mid] < target) {
                l = mid+1; 
            } 
            else {
                r = mid-1; 
            }
        }
        return false; 
    }
};
//finished in <10 minutes
