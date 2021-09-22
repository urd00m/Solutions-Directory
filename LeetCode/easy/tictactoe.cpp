class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        char board[3][3] = {{'-'},{'-'},{'-'}}; 
        char who = 'X'; 
        for(unsigned long i = 0; i < moves.size(); i++) {
            board[moves[i][0]][moves[i][1]] = who;
            if(isWinner(board, who)) {
                if(who == 'X') return "A";
                else return "B";
             }
            else{ 
                if(who == 'X') who = 'O';
                else who = 'X'; 
            }
        }
        if(moves.size() == 9) return "Draw";
        return "Pending";
    }
    
    bool isWinner(char board[3][3], char who) {
        for(unsigned long i = 0; i < 3; i++) {
            if(board[i][0] == who && board[i][0] == board[i][1] && board[i][0] == board[i][2]) return true; 
        }
        for(unsigned long i = 0; i < 3; i++) {
            if(board[0][i] == who && board[0][i] == board[1][i] && board[0][i] == board[2][i]) return true; 
        }
        if(board[0][0] == who && board[0][0] == board[1][1] && board[0][0] == board[2][2]) return true;
        if(board[0][2] == who && board[0][2] == board[1][1] && board[0][2] == board[2][0]) return true;       
        return false; 
    }
};
