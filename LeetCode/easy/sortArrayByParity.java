class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ret = new int[nums.length];
        int idx = 0; 
        
        // find evens 
        for(int i = 0; i < nums.length; i++)
            if(nums[i] % 2 == 0)
                ret[idx++] = nums[i]; 
        
        // find odds 
        for(int i = 0; i < nums.length; i++)
            if(nums[i] % 2 == 1)
                ret[idx++] = nums[i]; 
        
        return ret; 
    }
}
