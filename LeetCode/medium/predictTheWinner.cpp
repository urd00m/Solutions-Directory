class Solution {
public:
    bool recur(vector<int>& nums, int l, int r, int sa, int sb, int turn) {
        if(l > r) return (sa >= sb); 

        // recur
        bool ret = false; 
        if(turn == 0) {
            ret = ret || recur(nums, l+1, r, sa + nums[l], sb, !turn) || recur(nums, l, r-1, sa + nums[r], sb , !turn);
        }
        else {
            ret = true; 
            ret = ret && recur(nums, l+1, r, sa, sb + nums[l], !turn) && recur(nums, l, r-1, sa, sb + nums[r], !turn);
        }
        return ret; 
    }

    bool PredictTheWinner(vector<int>& nums) {
        // recursion explore all paths + backtracking 
        return recur(nums, 0, nums.size()-1, 0, 0, 0); 
    }
};
