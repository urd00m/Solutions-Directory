class Solution {
public:
    vector<vector<int>> generateMatrix(int x) {
        //four directions 
        int directionX[] = {0, 1, 0, -1};
        int directionY[] = {1, 0, -1, 0};
        long n = x*x; 
        int row = 0; 
        int col = 0; 
        int i = 1;
        int dir = 0; 
        vector<vector<int>> ret(x, vector(x, -1)); 
        vector<vector<int>> matrix(x, vector(x, -1)); 
        while(i <= n) {
            //going out of bounds 
            ret[row][col] = i; 
                
            //check to see if we need direction change 
            if(!(row+directionX[dir%4] < matrix.size() && row+directionX[dir%4] >= 0) || !(col+directionY[dir%4] < matrix[0].size() && col+directionY[dir%4] >= 0) || matrix[row+directionX[dir%4]][col+directionY[dir%4]] == INT32_MIN) {
                dir++; 
            }
            
            //update based on direction 
            matrix[row][col] = INT32_MIN; 
            row += directionX[dir%4];
            col += directionY[dir%4];

            i++; 
        }
        
        return ret; 
    }
};
