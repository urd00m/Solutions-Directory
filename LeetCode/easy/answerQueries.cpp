class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        // sort and calculate smallest size to largest size 
        // then just bin search 
        sort(nums.begin(), nums.end()); 

        // prefix sum 
        int sum = 0; 
        vector<int> sums; // total size is index + 1 
        for(int num : nums) sums.push_back( (sum+=num) ); 

        // bin search for each query 
        vector<int> ans; 
        for(int query : queries) {

            int l = 0, r = sums.size()-1; 
            while(l < r) {
                int mid = (l+r)/2 + 1; 

                // match
                if(sums[mid] == query) {
                    r = mid; 
                    break; 
                }

                // no match 
                if(sums[mid] < query) l = mid; 
                else r = mid - 1; 
            }
            if(sums[r] <= query) ans.push_back(r + 1); 
            else ans.push_back(0);
        }

        return ans; 
    }
};
