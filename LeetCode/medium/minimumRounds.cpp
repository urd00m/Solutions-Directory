class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        // group difficulties into groups 
        // if the group is not divisible by 2 or 3 then it is impossible, else return the quickest way to remove it 
        // remove by 3, the remainder is either 1 or 2, in both cases you add an additional total removal to. 
        // unless the total is 1 then it is impossible 
        unordered_map<int, int> occ; 
        for(int item : tasks) {
            if(occ.find(item) == occ.end()) occ[item] = 0; 
            occ[item]++; 
        }

        // begin summing up 
        int ret = 0;
        for(auto& [t, o] : occ) {
            if(o == 1) return -1; 
            else 
                ret += (o/3); 
                if(o%3) ret++; 
        }
        return ret; 
    }
};
