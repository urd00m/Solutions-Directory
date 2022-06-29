class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //sort 
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]) return a[0]-b[0];
                else return a[1] - b[1]; 
            }
        });
        
        //group by amount before it while keeping track of how many have been added
        ArrayList<int[]> ll = new ArrayList<int[]>(); 
        int group = people[0][1]; 
        int prev = -1; 
        for(int i = 0; i < people.length; i++) {
            int j = 0; 
            int greater = 0; 
            if(group != people[i][1]) {
                group = people[i][1]; 
                prev = 0;
            }
            while(j < ll.size() && greater < group) {
                if(ll.get(j)[0] >= people[i][0]) greater++; 
                j++; 
            }
            if(j <= prev)
                ll.add(prev=prev+1, people[i]); 
            else 
                ll.add(prev=j, people[i]); 
        }
        
        return ll.toArray(new int[people.length][2]); 
        
    }
}
