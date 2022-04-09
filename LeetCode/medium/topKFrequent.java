class Solution {
    public static int offset = 100000; 
    public int[] topKFrequent(int[] nums, int k) {
        pair[] counts = new pair[2*offset+1]; 
        for(int i = 0; i < 2*offset+1; i++) counts[i] = new pair(i-offset, 0);
        
        // count everything  O(n)
        for(int num : nums) {
            counts[num+offset].count++;  
        }
        
        //sort O(n log n)
        Arrays.sort(counts, new Comparator<pair>(){
           @Override
            public int compare(pair a, pair b) {
                return b.count - a.count; // decreasing order
            }
        });
        
        // get ret å
        int[] ret = new int[k];
        for(int i = 0; i < k; i++) {
            ret[i] = counts[i].num;
        }
        
        return ret;
    }
    
    
    // my pair class 
    public static class pair {
        public int num;
        public int count; 
        public pair() {
            count = 0; 
            num = -1; 
        }
        
        public pair(int n, int c) {
            num = n; 
            count = c; 
        }
    }
}
