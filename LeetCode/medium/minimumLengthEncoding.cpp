/*
    Answer taken from discuss but was the solution I had in mind which was to just brute force compare everything since length of words was only 7, the prefix tree was also another fast solution but pointless because input isn't that large. The mapping removal method here was clever, my idea was to sort by increasing length and compare sequentially and find a chance to not use it (slower but should pass).
*/

class Solution {
public:
    // Compare function for the condition of the sorting i.e. according to decreasing length 
    static bool compare (string& first, string& second) {
        return first.size() > second.size();
    }
    int minimumLengthEncoding(vector<string>& words) {
        unordered_map<string, int> mp;
        int ans = 0;
        
        //sorting the array in decreasing length sequence
        sort(words.begin(), words.end(), compare);

        //Entering each word in hash map.
        for(int i=0; i<words.size(); i++){
            mp[words[i]]++;
        }
        
        //For each word if it exist in hash map then add its length+1 to ans as # is also included.
        for(int i=0; i<words.size(); i++){
            int k = words[i].size();
            if(mp[words[i]] >0){
                ans += (k+1);
            }
            
            //Deleting record of any suffix of the word from hash map as it is already covered.
            for(int j=k-1; j>=0; j--){
                string s = words[i].substr(j, k-j);
                mp[s] = 0;
            }
        }
        return ans;
    }
};
