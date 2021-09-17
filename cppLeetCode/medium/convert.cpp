class Solution {
public:
    string convert(string s, int numRows) {
        //brute force 
        char matrix[numRows][1000]; //max 
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < 1000; j++) {
                matrix[i][j] = ' '; 
            }
        }
        //start filling it out 
        unsigned long curChar = 0; 
        int row = 0; 
        int column = 0; 
        bool down = true; 
        while(curChar < s.length()) {
            matrix[row][column] = s[curChar]; 
            if(numRows == 1) {
                row = 0; 
                column++; 
                curChar++; 
                continue; 
            }
            if(down) {
                //go down 
                row++; 
                //switch 
                if(row == numRows-1) {
                    down = false; 
                }
            }
            else {
                row--; 
                column++; 
                //switch 
                if(row == 0) {
                    down = true; 
                }
            }
            curChar++; 
        }
        
        //Create string
        string ret = ""; 
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < column+1; j++) {
                if(matrix[i][j] != ' ') {
                    ret += string(1, matrix[i][j]); 
                }
            }
        }
        
        return ret; 
    }
};
