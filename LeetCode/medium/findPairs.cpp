class Solution {
public:
    
    struct pair_hash
{
    template <class T1, class T2>
    std::size_t operator () (std::pair<T1, T2> const &pair) const
    {
        std::size_t h1 = std::hash<T1>()(pair.first);
        std::size_t h2 = std::hash<T2>()(pair.second);
 
        return h1 ^ h2;
    }
};
    int findPairs(vector<int>& nums, int k) {
        unordered_map<int, int> exists; 
        unordered_set<pair<int, int>, pair_hash> used; 
        
        for(long i = 0; i < nums.size(); i++) {
            if(exists.find(nums[i]) == exists.end()) exists[nums[i]] = 0;
            exists[nums[i]] += 1; 
        }
        
        // then look left and right 
        for(int num : nums) {
            //left of num 
            if(exists[num-k] >= 1 && !(k == 0 && exists[num-k] <= 1)) used.insert(make_pair(num-k, num));
            if(exists[num+k] >= 1 && k != 0) used.insert(make_pair(num, num+k));
        }
        return used.size();  
    }
};
