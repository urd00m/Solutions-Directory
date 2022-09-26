class Solution {
public:
    vector<int> par; 
    
    
    int getparufds(int a) {
        int cur = a; 
        while(par[cur] != cur) cur = par[cur]; 
        return cur; 
    }
    
    void unionufds(int a, int b) {
        if(a == b) return;
        par[getparufds(b)] = getparufds(a); // set parent to a 
    }
    
    bool issameset(int a, int b) {
        return getparufds(a) == getparufds(b); // have same parent
    }
    
    bool equationsPossible(vector<string>& equations) {
        // do an equals pass 
        // ufds seems overkill  
        par = vector(26, 0); // init 
        for(int i = 0; i < 26; i++) par[i] = i; // set itself parent
        
        // first pass for == 
        for(int i = 0; i < equations.size(); i++) {
            if(equations[i][1] == '=') { // set them as the same group 
                unionufds(equations[i][0] - 'a', equations[i][3] - 'a'); 
            }
        }
        
        // second pass for != 
        for(int i = 0; i < equations.size(); i++) {
            if(equations[i][1] == '!') {
                if(issameset(equations[i][0] - 'a', equations[i][3] - 'a')) return false;
            }
        }
        return true; 
    }
};
