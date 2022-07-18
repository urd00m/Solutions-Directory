class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        // O(n^2) + 
        
        if(matrix.size() == 0 || target > 10000000) return 0; // cant reach target greater than 10^7 
        long n = matrix.size(), m = matrix[0].size(); 
        /* pre[i][j] = pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1]+matrix[i][j] (couting principle aUb = a + b - a \intersect b )
           0 0 0 0 
           0 0 1 1
           0 1 3 4 
           0 1 4 5
        */
        // compute prefix tree 
        //vector<vector<int>> pre = vector(n+1, vector(m+1, 0)); //one index it (easier to deal with corner cases ) 
        int pre[101][101];  
        for(long i = 1; i <= n; i++) 
            for(long j = 1; j <= m; j++)  
                pre[i][j] = pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1]+matrix[i-1][j-1]; 
        
        
        // determine # submatrices that match target 
        // we can switch to this to a 1d subarray sum to target problem by only alternating one column and fixing the 2 rows 
        int ret = 0; 
        for(long r1 = 1; r1 <= n; r1++) {
            for(long r2 = r1; r2 <= n; r2++) {
                // for 1d sum 
                unordered_map<int,int> sums; 
                sums[0] = 1; 
                for(long c = 1; c <= m; c++) {
                    int mat_sum = sum(pre, r1, 1, r2, c); 
                    if(sums.find(mat_sum-target) != sums.end())
                        ret += sums[mat_sum-target]; 
                    
                    if(sums.find(mat_sum) == sums.end()) 
                        sums[mat_sum] = 0;
                    sums[mat_sum]++; 
                }
            }
        }
        return ret;
    }
    
    // helper function  O(1)
    /*
        To find the submatrix sum do 
        pre[r2][c2]-pre[r2][c1-1]-pre[r1-1][c2]+pre[r1-1][c1-1]
        (r1,c1) top left (1-indexed, 0 will break it)
        (r2,c2) bottom right  
    */
    static int sum(int pre[][101], int r1, int c1, int r2, int c2) {
        return pre[r2][c2]-pre[r2][c1-1]-pre[r1-1][c2]+pre[r1-1][c1-1]; 
    }
};
