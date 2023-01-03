class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        // an interesting idea is to first go in row major order where you access the first row then second, this should yield better cache hits 
        // scan by column then by row 
        int ret = 0; 
        for(int i = 0; i < strs[0].size(); i++) {
            char cur = strs[0][i]; 
            for(int j = 0; j < strs.size(); j++) {
                if(cur > strs[j][i]) {
                    ret++;
                    break; 
                }
                cur = strs[j][i]; 
            }
        }

        // cache optimized solution 
        // vector<char> col_cur = vector(strs[0].size(), '\0');  
        // for(int i = 0; i < strs[0].size(); i++) col_cur[i] = strs[0][i]; 
        // int ret = 0; 
        // for(int i = 0; i < strs.size(); i++) {
        //     for(int j = 0; j < strs[0].size(); j++) {
        //         if(strs[i][j] < col_cur[j]) {
        //             col_cur[j] = '\0'; 
        //             ret++; 
        //         }
        //         else if(col_cur[j] != '\0')
        //             col_cur[j] = strs[i][j]; 
        //     }
        // }

        return ret; 
    }
};
