class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        // i(i+1)/2 to fill up the ith row (1 indexed)
        // the distribution of liquid is ncr(row, cup num) (zero indexed)
        
        // if you make it to that row (calculate the amount that does)
        // The total percent of water you get is ncr(row, cup num)/2^i (zero indexed)
        // if you poured more than 5050 cups (more cups than we have) then it is 1
        
        // simulation ? 
        vector<vector<double>> cups = vector(100, vector(100, 0.0)); // 100 by 100 bounds: 1 by 1, then 2 by 2, columns bounded by row number
        cups[0][0] = poured; 
        for(int i = 0; i < 99; i++) { // go down the rows 
            for(int j = 0; j <= i; j++) { // go across the cups 
                if(cups[i][j] <= 1.0) continue; //cup doesn't have enough to overflow 
                cups[i+1][j] += (cups[i][j] - 1.0)/2; // add overflow to cup 
                cups[i+1][j+1] += (cups[i][j] - 1.0)/2; 
            }
            cout << endl; 
        }
    
        return (cups[query_row][query_glass] > 1 ? 1 : cups[query_row][query_glass]); 
    }
};
