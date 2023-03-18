class BrowserHistory {
public:
    vector<string> hist; 
    int cur_ptr; 
    int forward_tail; 
    BrowserHistory(string homepage) {
        hist.clear(); 
        hist.push_back(homepage);
        cur_ptr = 0; 
        forward_tail = 0; 
    }
    
    void visit(string url) {
        hist.erase(hist.begin()+cur_ptr+1, hist.end()); 
        hist.push_back(url); 
        cur_ptr++; 
    }
    
    string back(int steps) {
        if(steps > cur_ptr) steps = cur_ptr; 
        cur_ptr -= steps; 
        return hist[cur_ptr]; 
    }
    
    string forward(int steps) {
        if(steps + cur_ptr >= hist.size()) steps = hist.size()-cur_ptr-1; 
        cur_ptr += steps; 
        return hist[cur_ptr]; 
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */
