class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        vector<int> ret;
        for(long i = 0; i < k; i++){
            int max = INT32_MAX; 
            int idx = -1; 
            for(long j = 0; j < mat.size(); j++) {
                bool found = false; 
                for(int item : ret) {
                    if(item == j) {
                        found = true;
                        break; 
                    }
                }
                if(found == true) continue; 
                
                int count = 0; 
                for(int item : mat[j]) {
                    if(item != 1) break; 
                    count++; 
                }
                if(count < max) {
                    max = count; 
                    idx = j; 
                }
            }
            ret.push_back(idx);
        }   
        
        return ret; 
    }
};
