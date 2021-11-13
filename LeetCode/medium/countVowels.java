class Solution {
    public long countVowels(String word) {
        long ret = 0; 
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                ret += (i+1L)*(word.length()-i); 
            }
        }
        return ret; 
    }
}
