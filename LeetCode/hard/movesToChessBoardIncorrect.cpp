class Solution {
public:
    int movesToChessboard(vector<vector<int>>& board) {
        //for odds
        /*
            Base Check: 
            1) Should have n/2+1 rows/columns of 1 and n/2 rows/columns of 1 
            2) The rows/columns with n/2+1 1's should be equal and the rows with n/2 1's should be equal 
        */
        //for even
        /*
            Base Check:
            1) Row and Columns must have at n/2 ones (should be two different equal sets of n/2 1s)
            2) The rows (should be 2 sets) should all be equal
        */
        
        /*
            Counting:
            1) count the number of misplaced rows/2 add to count
            2) count the number of mispalced columns/2 add to count 
            3) Assert the misplaced rows/columns should always be divisible by 2
        */
        //base case
        long n = board.size();
        if(n <= 2) {
            vector<vector<int>> temp1 =  {{1, 0}, {0, 1}}; 
            vector<vector<int>> temp2 =  {{0, 1}, {1, 0}}; 
            if(n == 2 && (board != temp1 && board != temp2) ) {
                return -1;
            }
            return 0;
        }
        long rowsA = n%2==0 ? n/2 : n/2+1; //number of 1s in row 
        long rowsB = n/2; 
        long columnsA = n%2==0 ? n/2 : n/2+1; 
        long columnsB = n/2; 
        
        long numRA = 0;
        long numRB = 0;
        vector<int> rowA; 
        vector<int> rowB; 
        //count rows
        for(long i = 0; i < n; i++) {
            long count = 0;
            for(long j = 0; j < n; j++) {
                if(board[i][j] == 1) count++;
            }
            if(numRA != rowsA && count == rowsA) { //the total of Row A's 
                numRA++; 
                if(rowA.empty()) {
                    rowA = board[i]; 
                }   
                else if(rowA != board[i]) { //if the row doesn't match previous rows then impossible
                    return -1;
                }
            }
            else if(numRB != rowsB && count == rowsB) {
                numRB++; 
                if(rowB.empty()) {
                    rowB = board[i]; 
                }   
                else if(rowB != board[i]) { //if the row doesn't match previous rows then impossible
                    return -1;
                }
            }
            else  // a row doesn't meet the specification's it is impossible to solve
                return -1; 
        }
        
        long numCA = 0;
        long numCB = 0;
        vector<int> columnA;
        vector<int> columnB;
        //count rows
        for(long i = 0; i < n; i++) {
            long count = 0;
            for(long j = 0; j < n; j++) {
                if(board[i][j] == 1) count++;
            }
            if(numCA != columnsA && count == columnsA) { //the total of Row A's 
                numCA++; 
                if(columnA.empty()) {
                    columnA = board[i]; 
                }   
                else if(columnA != board[i]) { //if the row doesn't match previous rows then impossible
                    return -1;
                }
            }
            else if(numCB != columnsB && count == columnsB) {
                numCB++; 
                if(columnB.empty()) {
                    columnB = board[i]; 
                }   
                else if(columnB != board[i]) { //if the row doesn't match previous rows then impossible
                    return -1;
                }
            }
            else  // a row doesn't meet the specification's it is impossible to solve
                return -1; 
        }
        
        long ret = 0; 
        if(n%2==1) {
            // Count number of rows 
            // we can we assume the matrix is of correct form 
            for(long i = 0; i < n; i+=2) {
                long num_ones = 0; 
                for(long j = 0; j < n; j++) {
                    if(board[i][j] == 1) num_ones++; 
                }
                if(num_ones != rowsA) ret++;
                cout << num_ones <<  " " << rowsA << endl;
            }
            // Count number of columns 
            for(long i = 0; i < n; i+=2) {
                long num_ones = 0; 
                for(long j = 0; j < n; j++) {
                    if(board[j][i] == 1) num_ones++; 
                }
                if(num_ones != columnsA) ret++;
                cout << num_ones << " " << columnsA << endl;
            }
        }
        if(n%2==0) {
            // Count number of rows 
            // we can we assume the matrix is of correct form 
            long min1 = 0;
            long min0 = 0; 
            for(long i = 0; i < n; i+=2) {
                if(board[i][0] != 1) min1++;
                if(board[i][0] != 0) min0++;
            }
            // Count number of columns 
            for(long i = 0; i < n; i+=2) {
                if(board[0][i] != 1) min1++;
                if(board[0][i] != 0) min0++;
            }
            ret = min1 < min0 ? min1 : min0; 
        }
        
        return ret;
    }
};
