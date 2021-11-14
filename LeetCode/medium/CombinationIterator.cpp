set<string>GenaretallComb(string s,int len){
    int mask = 1<<s.length();
    set<string>hold;
    string comString = "";
    for(int no=1;no<mask;no++){
        int num = no,i = 0;
        while(num){
            if(num&1)comString = comString + s[i];
            i++,num>>=1;
        }
        if(comString.length()==len)hold.insert(comString);
        comString = "";
    }
    return hold;
}

class CombinationIterator {
public:
    set<string>st;
    set <string> :: iterator cur;
    CombinationIterator(string characters, int combinationLength) {
        this->st = GenaretallComb(characters,combinationLength);
        this->cur = begin(st);
    }
    
    string next() {
        return cur==end(st)?"":*cur++;
    }
    
    bool hasNext() {
        return cur!=end(st);
    }
};

//This solution was taken from the discussion to better understand teh solution 
//Solution credits: https://leetcode.com/problems/iterator-for-combination/discuss/789164/C%2B%2B-Using-Bit-manipulation-or-Detail-Explain
