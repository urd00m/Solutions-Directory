class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        int count = 0; 
        unordered_map<int, int> a; 
        for(int item : nums1) {
            for(int item2 : nums2) {
                a[item+item2]++; 
            }
        }
        
        //count 
        for(int item : nums3) {
            for(int item2 : nums4) {
                count += a[0-item-item2]; 
            }
        }
        
        return count; 
    }
};
