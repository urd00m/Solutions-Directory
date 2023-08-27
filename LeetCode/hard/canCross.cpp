class Solution {
public:
    // returns idx of stone that you land on 
    // -1 if none 
    int stoneIdx(vector<int>& stones, int cur_idx, int jump_size) {
        int new_pos = stones[cur_idx] + jump_size; 
        for(int i = cur_idx+1; i < stones.size(); i++) {
            if(new_pos == stones[i]) return i; 
            if(new_pos < stones[i]) return -1; // didn't land on one 
        }
        return -1; 
    }

    bool canCross(vector<int>& stones) {
        // max jump can be 2000 
        // 2D dp --> last jump x stone index
        vector<vector<bool>> dp = vector(stones.size(), vector(2002, false)); 
        dp[0][0] = true; 

        // start dp 
        // state update:
        // either you can jump k-1, k, or k+1 and if it doesn't land on a stone you fail, if it lands on a stone you succeed 
        for(int i = 0; i < stones.size()-1; i++) {
            for(int j = 0; j < 2002; j++) {
                if(dp[i][j] == false) continue; 
                // j-1
                int new_idx = stoneIdx(stones, i, j-1); 
                if(new_idx != -1) dp[new_idx][j-1] = true; 

                // j 
                new_idx = stoneIdx(stones, i, j); 
                if(new_idx != -1) dp[new_idx][j] = true; 

                // j+1
                new_idx = stoneIdx(stones, i, j+1); 
                if(new_idx != -1) dp[new_idx][j+1] = true; 
            }
        }

        // ret 
        for(int i = 1; i < 2002; i++) 
            if(dp[stones.size()-1][i]) return true; 
        return false; 
    }
};
