class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length+ nums2.length];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < merged.length; i++) {
            if(index1 == nums1.length) {
                merged[i] = nums2[index2];
                index2++;
            }
            else if(index2 == nums2.length) {
                merged[i] = nums1[index1];
                index1++;
            }
            else if(nums1[index1] < nums2[index2]) {
                merged[i] = nums1[index1];
                index1++;
            }
            else if(nums1[index1] > nums2[index2]) {
                merged[i] = nums2[index2];
                index2++;
            }
            else {
                merged[i] = nums1[index1];
                merged[i+1] = nums2[index2];
                i++;
                index1++;
                index2++;
            }
        }
        if(merged.length%2 == 0) return (merged[merged.length/2-1]+merged[merged.length/2])/2.0;
        else return merged[merged.length/2];
    }
}
