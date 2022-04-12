class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        vector<vector<int>> temp = vector(board.size(), vector(board[0].size(), 0));

        for(long i = 0; i < temp.size(); i++) {
            for(long j = 0; j < temp[0].size(); j++) {
                temp[i][j] = board[i][j]; 
            }
        } 
        
        for(long i = 0; i < temp.size(); i++) {
            for(long j = 0; j < temp[i].size(); j++) {
                int cnt = countNeighbors(board, i, j); 
                if(cnt < 2) {
                    temp[i][j] = 0;
                }
                else if(board[i][j] == 1 && (cnt == 2 || cnt == 3)) temp[i][j] = 1;
                else if(cnt > 3) temp[i][j] = 0;
                else if(board[i][j] == 0 && cnt == 3) temp[i][j] = 1; 
            }
        }
        
      for(long i = 0; i < temp.size(); i++) {
        for(long j = 0; j < temp[i].size(); j++) {
            cout << temp[i][j] << " ";
            board[i][j] = temp[i][j];
        }
        cout << endl; 
      }
    }
    
    int countNeighbors(vector<vector<int>>& board, long row, long col) {
        int ret = 0; 
        if(row != 0 && col != 0 && board[row-1][col-1] == 1) {
            ret++; 
        }
        if(row != 0 &&  board[row-1][col] == 1) ret++; 
        if(row != 0 && col != board[row].size()-1 &&  board[row-1][col+1] == 1) ret++; 
        if(col != 0 &&  board[row][col-1] == 1) ret++; 
        if(col != board[row].size()-1 &&  board[row][col+1] == 1) ret++; 
        if(row != board.size()-1 && col != 0 && board[row+1][col-1] == 1) ret++; 
        if(row != board.size()-1 && board[row+1][col] == 1) ret++; 
        if(row != board.size()-1 && col != board[row].size()-1 && board[row+1][col+1] == 1) ret++; 
        
        return ret; 
    }
};
