class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        //kind of binary search 
        long l = 0; 
        long r = nums.size(); 
        while(l <= r) {
            long mid = (l+r)/2; 
            //compare left right 
            if( mid != nums.size()-1 && ((nums[mid] == nums[mid+1]) && (nums.size()-mid)%2==0) ) {
                //the to the right is good 
                r = mid-1; 
            }
            else if( mid != nums.size()-1 && ((nums[mid] == nums[mid+1]) && (nums.size()-mid)%2==1) ) {
                //the to the left is good since the right isn't  
                l = mid+1; 
            }
            else if(mid != 0 && ((nums[mid] == nums[mid-1]) && (nums.size()-mid+1)%2==0) ) {
                //the to the right is good 
                r = mid-1; 
            }
            else if(mid != 0 && ((nums[mid] == nums[mid-1]) && (nums.size()-mid+1)%2==1) ) {
                //the to the left is good since the right isn't  
                l = mid+1; 
            }
            else {
                //we found it 
                return nums[mid];
            }
        }
        return nums[l]; 
    }
};
