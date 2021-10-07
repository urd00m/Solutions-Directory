class Solution {
public:
    vector<vector<bool>> visited; 
    bool exist(vector<vector<char>>& board, string word) {
        vector<vector<bool>> temp(board.size(), vector<bool>(board[0].size(), false)); 
        visited = temp; 
        for(long i = 0; i < board.size(); i++) {
            for(long j = 0; j < board[0].size(); j++) {
                bool ret = dfs(board, word, 0, i, j);
                if(ret == true) {
                    return true; 
                }
            }
        }
        return false; 
    }
    
    bool dfs(vector<vector<char>>& board, string word, long idx, long row, int col) {
        if(idx == word.size()) {
            return false; 
        }
        //check bounds
        if(row >= board.size() || row < 0 || col >= board[0].size() || col < 0 || visited[row][col] == true) {   
            return false; 
        }
        if(word[idx] == board[row][col]) {
            if(idx == word.size()-1) { //we have the full word 
                return true; 
            }
            else { //keep going
                bool temp = false; 
                visited[row][col] = true; 
                temp = temp | dfs(board, word, idx+1, row+1, col); 
                temp = temp | dfs(board, word, idx+1, row-1, col); 
                temp = temp | dfs(board, word, idx+1, row, col+1); 
                temp = temp | dfs(board, word, idx+1, row, col-1); 
                visited[row][col] = false; 
                return temp; 
            }
        } 
        return false; //prune it 
    }
};
