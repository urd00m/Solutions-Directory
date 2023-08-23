class Solution {
public:
    string reorganizeString(string s) {
      // count characters if any pass m + 1 then return null 
      // sort the characters and weave the two biggest until run out 
      vector<int> cnt = vector(26, 0); 
      for(char c : s) cnt[c - 'a']++; 

      // add to pq 
      priority_queue<pair<int, char>> pq; 
      int m = (s.size() + 1)/2; 
      for(int i = 0; i < 26; i++) {
        if(cnt[i] > m) return ""; 
        pq.push({cnt[i], 'a'+i});
      }

      // start the weave 
      string ret = "";
      while(true) {
          pair<int, char> l = pq.top(); pq.pop();
          pair<int, char> r = pq.top(); pq.pop();

          if(l.first == 0 && r.first == 0) break; 

          // add
          ret += l.second;
          if(r.first != 0) ret += r.second; 
          l.first--;
          if(r.first != 0) r.first--;
          pq.push(l);
          pq.push(r);
      }
      return ret; 
    }
};
