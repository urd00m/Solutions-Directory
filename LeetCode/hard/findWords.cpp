class Solution {
public:    
    vector<vector<bool>> visited; 
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<vector<bool>> temp(board.size(), vector<bool>(board[0].size(), false)); 
        visited = temp; 
        
        vector<string> ret; 
        //for(size_t word_idx = 0; word_idx < words.size(); word_idx++) {
        for(auto &x: words) {
            bool found = false;
            reverse(x.begin(), x.end());
            for(long i = 0; i < board.size(); i++) {
                
                for(long j = 0; j < board[0].size(); j++) {
                    if(dfs(board, x, 0, i, j)) {
                    //if(dfs2(board, i, j, words[word_idx])) {
                        found = true;
                        break; 
                    }
                }
                if(found) break; 
            }
            if(found) {
                reverse(x.begin(), x.end());
                ret.push_back(x);
            }
        }
        return ret; 
    }
    bool dfs2(vector<vector<char>>& board, int i, int j, string& word) {
        if (!word.size())
            return true;
        if (i<0 || i>=board.size() || j<0 || j>=board[0].size() || board[i][j] != word[0])  
            return false;
        char c = board[i][j];
        board[i][j] = '*';
        string s = word.substr(1);
        bool ret = dfs2(board, i-1, j, s) || dfs2(board, i+1, j, s) || dfs2(board, i, j-1, s) || dfs2(board, i, j+1, s);
        board[i][j] = c;
        return ret;
    }
    bool dfs(vector<vector<char>>& board, string& word, long idx, long row, int col) {
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
