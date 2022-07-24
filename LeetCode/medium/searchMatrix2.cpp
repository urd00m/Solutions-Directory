class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        long n = matrix.size(); long m = matrix[0].size(); 
        
        // horizontally O(log n) then vertically O(log m)
        // binary search on horitizontal row 0 
        /*
        int l = 0; int r = m-1; 
        int col = -1; 
        while(l < r) {
            int mid = (l+r)/2;
            
            if(matrix[0][mid] == target) return true; 
            
            // standard 
            if(matrix[0][mid] < target) l = mid+1; 
            else r = mid - 1; 
        }
        if(matrix[0][l] > target && l != 0) col = l-1; 
        else col = l; 
        cout << col << endl; 
        */
        
        // bin search every row O(nlogm)
        for(int col = 0; col < m; col++) {
            int l = 0, r = n-1; 
            while(l <= r) {
                int mid = (l+r)/2; 

                if(matrix[mid][col] == target) return true; 

                if(matrix[mid][col] < target) l = mid+1; 
                else r = mid-1; 
            }
        }
        return false; 
    }
};
