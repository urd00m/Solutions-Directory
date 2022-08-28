class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        // go bottom up then left to rigth 
        long n = mat.size(); long m = mat[0].size(); 
        
        vector<vector<int>> ret = mat; 
        
        // vertical portion 
        vector<int> temp; 
        for(long k = 0; k < n; k++) {
            
            // get items 
            int i = k; 
            int j = 0; 
            while(i < n && j < m) {
                temp.push_back(mat[i][j]); 
                i++; j++; 
            }
            
            // sort
            sort(temp.begin(), temp.end()); 
            
            // pushback 
            i = k; j = 0; 
            while(i < n && j < m) {
                ret[i][j] = temp[j]; 
                i++; j++; 
            }
            temp.clear(); 
        }
        
        // horizontal portion 
        for(long k = 1; k < m; k++) {
            int i = 0; 
            int j = k; 
            while(i < n && j < m) {
                temp.push_back(mat[i][j]); 
                i++; j++; 
            }
            
            // sort
            sort(temp.begin(), temp.end()); 
            
            // pushback 
            i = 0; j = k; 
            while(i < n && j < m) {
                ret[i][j] = temp[i]; 
                i++; j++; 
            }
            temp.clear(); 
        }
        
        return ret; 
    }
};
