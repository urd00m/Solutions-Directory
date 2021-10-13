class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        //four directions 
        int directionX[] = {0, 1, 0, -1};
        int directionY[] = {1, 0, -1, 0};
        long n = matrix.size()*matrix[0].size(); 
        vector<int> ret(n, 0); 
        int row = 0; 
        int col = 0; 
        int i = 0;
        int dir = 0; 
        while(i < n) {
            //going out of bounds 
            //cout << i << " " << row << " " << col << endl; 
            ret[i] = matrix[row][col];
            //check to see if we need direction change 
            //cout << "values " << row+directionX[dir%4] << " " <<col+directionY[dir%4] <<" " << matrix[row+directionX[dir%4]][col+directionY[dir%4]] << endl; 
            if(!(row+directionX[dir%4] < matrix.size() && row+directionX[dir%4] >= 0) || !(col+directionY[dir%4] < matrix[0].size() && col+directionY[dir%4] >= 0) || matrix[row+directionX[dir%4]][col+directionY[dir%4]] == INT32_MIN) {
                dir++; 
            }
            
            //cout << "dir " << dir << endl; 
            //update based on direction 
            //cout << "row " << row << " " << col << endl; 
            matrix[row][col] = INT32_MIN; 
            row += directionX[dir%4];
            col += directionY[dir%4];
            //cout << "row " << row << " " << col << endl; 

            i++; 
        }
        
        return ret; 
    }
};
