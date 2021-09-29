class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        //horizontal check 
        for(long i = 0; i < 9; i++) {
            int check[10] = {0,0,0,0,0,0,0,0,0,0}; 
            for(long j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                if(board[i][j] - '0' <= 0 || board[i][j] - '0' > 9 || check[board[i][j] - '0'] == 1) return false; 
                check[board[i][j] - '0']++;
            }    
        }
        
        //vertical check 
        for(long i = a; i < 9; i++) {
            int check[10] = {0,0,0,0,0,0,0,0,0,0}; 
            for(long j = 0; j < 9; j++) {
                if(board[j][i] == '.') continue;
                if(board[j][i] - '0' <= 0 || board[j][i] - '0' > 9 || check[board[j][i] - '0'] == 1) return false; 
                check[board[j][i] - '0']++;
            }    
        }
        
        //box check 
        for(long box = 0; box < 9; box++) {
            long rowIdx = 0; 
            int check[10] = {0,0,0,0,0,0,0,0,0,0}; 
            for(long i = (box/3)*3; rowIdx < 3; rowIdx++) {
                long colIdx = 0; 
                for(long j = (box%3)*3; colIdx < 3; colIdx++) {
                    if(board[i+rowIdx][j+colIdx] == '.') continue;
                    if(board[i+rowIdx][j+colIdx] - '0' <= 0 || board[i+rowIdx][j+colIdx] - '0' > 9 || check[board[i+rowIdx][j+colIdx] - '0'] == 1) return false; 
                    check[board[i+rowIdx][j+colIdx] - '0']++;
                }
            }
        }
        
        return true; 
    }
};
