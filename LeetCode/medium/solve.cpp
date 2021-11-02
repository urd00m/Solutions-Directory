class Solution {
public:
   
    void solve(vector<vector<char>>& board) {
        vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size(), false)); 
        //break into blocks using flood fill, everything on the outside is safe 
        //once hit a 0 block, do floow fill and mark them all as safe 
        //then run through in n^2 time to fill in the x's 
        for(long i = 0; i < board[0].size(); i++) {
            if(board[0][i] == 'O') flood(board, 0, i, visited);
            if(board[board.size()-1][i] == 'O') flood(board, board.size()-1, i, visited);
        }
        for(long i = 0; i < board.size(); i++) {
            if(board[i][0] == 'O') flood(board, i, 0, visited);
            if(board[i][board[0].size()-1] == 'O') flood(board, i, board[0].size()-1, visited);
        }
        
        //scan 
        for(long i = 0; i < board.size(); i++) {
            for(long j = 0; j < board[0].size(); j++) {
                if(board[i][j] == 'o') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';   
            }
        }
    }
    
    void flood(vector<vector<char>>& board, long row, long col, vector<vector<bool>>& visited) {
        if(row < 0 || row >= board.size()) return;
        if(col < 0 || col >= board[0].size()) return;
        if(visited[row][col] == true) return;

        if(board[row][col] == 'X' || board[row][col] == 'o') return; 
        if(board[row][col] == 'O') board[row][col] = 'o';
        visited[row][col] = true;
        flood(board, row+1, col, visited);
        flood(board, row-1, col, visited);
        flood(board, row, col+1, visited);
        flood(board, row, col-1, visited);   
    }
};
