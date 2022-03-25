class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //sort by min and take the minimum n
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override 
            public int compare(int[] a, int[] b) {
                return (a[0]-a[1])-(b[0]-b[1]);
            }
        });
        
        //for(int[] ary : costs)
          //  System.out.println(ary[0] + " " + ary[1]);
        
        // n go to a, rest go to be 
        int ret = 0; 
        for(int i = 0; i < costs.length/2; i++) {
            ret += costs[i][0]; 
        }
        for(int i = costs.length/2; i < costs.length; i++) {
            ret += costs[i][1]; 
        }

        return ret; 
    }
}
