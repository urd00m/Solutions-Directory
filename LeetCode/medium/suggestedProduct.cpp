class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //sort 
        List<String> words = new ArrayList<String>();
        for(String word : products) {
            words.add(word); 
        }        
        
        // Begin output 
        List<List<String>> ret = new ArrayList<List<String>>();

        // iterate 
        for(int i = 0; i < searchWord.length(); i++) {
            List<String> cur = new ArrayList<String>(); 
            
            char cur_search = searchWord.charAt(i);
            List<String> wordsNew = new ArrayList<String>(); 
            for(String word : words) {
                if(i < word.length() && word.charAt(i) == cur_search)
                    wordsNew.add(word); 
            }
            Collections.sort(wordsNew); 
            for(int j = 0; j < 3; j++) {
                if(j >= wordsNew.size()) break; 
                cur.add(wordsNew.get(j)); 
            }
            words = wordsNew; 
            ret.add(cur); 
        }
        
        return ret; 
    }
}
