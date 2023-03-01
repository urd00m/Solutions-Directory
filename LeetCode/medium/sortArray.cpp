class Solution {
public:
    vector<int> merge_sort(vector<int>& nums) {
        if(nums.size() == 1) return nums; 

        vector<int> left((nums.size()/2)), right(((nums.size()+1)/2)); 
        copy(nums.begin(), nums.begin()+(nums.size()/2), left.begin());
        copy(nums.begin()+(nums.size()/2), nums.end(), right.begin());
        left = merge_sort(left);
        right = merge_sort(right);
        return merge(left, right);
    }

    vector<int> merge(vector<int>& a, vector<int>& b) {
        vector<int> ret;
        int n = a.size() + b.size(); 
        int x = 0, y = 0; 
        for(int i = 0; i < n; i++) {
            if(x != a.size() && y != b.size()) {
                if(a[x] < b[y]) ret.push_back(a[x++]); 
                else ret.push_back(b[y++]); 
            }
            else if(x == a.size()) ret.push_back(b[y++]); 
            else if(y == b.size()) ret.push_back(a[x++]); 
            else {
                assert(0 == 1); // not possible! 
            }
        }
        return ret; 
    }

    vector<int> sortArray(vector<int>& nums) {
        // implement mergesort  
        return merge_sort(nums); 
    }
};
// not the most efficient solution at all lol, should have done in place but oh well
