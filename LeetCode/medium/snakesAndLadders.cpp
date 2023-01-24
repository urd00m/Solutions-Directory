#define INDEXTONUM(n, row, col) ( (((n)-(row))*(n)) - ((row) % 2 != ((n)-1)%2 ? (col) : (n-col-1)) )
#define NUMTOINDEX_ROW(n, num) ( (int)((n)*(n) - (num))/(n) )
#define NUMTOINDEX_COL(n, row, num)  ( ((row)%2 != ((n)-1)%2) ? (int)((n)*(n) - (num))%(n) : (n) - 1 - (int)((n)*(n) - (num))%(n) )


class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        // dp in the bfs style 
        // need to figure out way to map indexes to number
        // indexes to number: (n-(row))*n -> if(row % 2 != n-1%2) -= (col) else -= (n-col-1)
        // n = 6 | 34 -> (0, 2) -> 6*6 - 6-2-1 = 36 - 2 = 34 
        // mapping num to index 
        // n = 6, num = 34 | row: (n^2 - num)/n col:  (n^2 - num)%n
        // 36-34 = 2 --> row = 0 col = 2 
        // 36 - 27 = 9 row = 1 col = 3 -> 6 - 3 - 1 = 2 
        
        int n = board.size(); 
        vector<int> dp = vector(n*n+1, INT32_MAX); 
        dp[1] = 0; 

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         int num = INDEXTONUM(n, i, j);
        //         int row = NUMTOINDEX_ROW(n, num);
        //         int col = NUMTOINDEX_COL(n, row, num);
        //         cout << i << " " << j << " " << num << " " << row << " " << col << endl; 
        //     }
        // }

        // bfs with dp 
        queue<int> next; 
        next.push(1); 
        while(!next.empty()) {
            int cur = next.front(); next.pop(); 

            // visit children 
            for(int i = 1; i <= 6; i++) {
                int next_num = cur + i; 
                if(next_num > n*n) break; 
                int next_row = NUMTOINDEX_ROW(n, next_num);
                int next_col = NUMTOINDEX_COL(n, next_row, next_num); 
                if(board[next_row][next_col] == -1) {
                    if(dp[cur] + 1 < dp[next_num]) {
                        dp[next_num] = dp[cur] + 1; 
                        next.push(next_num); 
                    }
                }
                else {
                    int next_next_num = board[next_row][next_col]; 
                    if(dp[cur] + 1 < dp[next_next_num]) {
                        dp[next_next_num] = dp[cur] + 1; 
                        next.push(next_next_num); 
                    }
                }
            }
        }

        return dp[n*n] == INT32_MAX ? -1 : dp[n*n]; 
    }
};

/*
[-1,-1,27,13,-1,25,-1]
[-1,-1,-1,-1,-1,-1,-1]
[44,-1,8,-1,-1,2,-1]
[-1,30,-1,-1,-1,-1,-1]
[3,-1,20,-1,46,6,-1]
[-1,-1,-1,-1,-1,-1,29]
[-1,29,21,33,-1,-1,-1]

0 0 43 0 0
0 1 44 0 1
0 2 45 0 2
0 3 46 0 3
0 4 47 0 4
0 5 48 0 5
0 6 49 0 6
1 0 42 1 0
1 1 41 1 1
1 2 40 1 2
1 3 39 1 3
1 4 38 1 4
1 5 37 1 5
1 6 36 1 6
2 0 29 2 0
2 1 30 2 1
2 2 31 2 2
2 3 32 2 3
2 4 33 2 4
2 5 34 2 5
2 6 35 2 6
3 0 28 3 0
3 1 27 3 1
3 2 26 3 2
3 3 25 3 3
3 4 24 3 4
3 5 23 3 5
3 6 22 3 6
4 0 15 4 0
4 1 16 4 1
4 2 17 4 2
4 3 18 4 3
4 4 19 4 4
4 5 20 4 5
4 6 21 4 6
5 0 14 5 0
5 1 13 5 1
5 2 12 5 2
5 3 11 5 3
5 4 10 5 4
5 5 9 5 5
5 6 8 5 6
6 0 1 6 0
6 1 2 6 1
6 2 3 6 2
6 3 4 6 3
6 4 5 6 4
6 5 6 6 5
6 6 7 6 6

*/
