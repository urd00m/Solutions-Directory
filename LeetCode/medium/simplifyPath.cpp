class Solution {
public:
    string simplifyPath(string path) {
        //use a stack 
        stack<string> simplePath; 
        
        //parse the string 
        path += "/";
        string cur = ""; 
        for(size_t i = 0; i < path.size(); i++) {
            if(path[i] == '/' && cur != "") {
                if(cur == "..") {
                    if(simplePath.size() > 0) simplePath.pop(); 
                }
                else if(cur == ".") {
                    //do nothing
                }
                else 
                    simplePath.push(cur); 
                cur = ""; 
            }
            else if (path[i] != '/') {
                cur += string(1, path[i]); 
            }
        }
        /*
        if(cur != "") {
            simplePath.push(cur); 
        }*/
        
        //convert to string 
        if(simplePath.size() == 0) return "/";
        vector<string> items;
        while(simplePath.empty() == false) {
            items.push_back(simplePath.top()); simplePath.pop(); 
        }
        
        //reverse 
        reverse(items.begin(), items.end()); 
        
        //set up ret
        string ret = ""; 
        for(long i = 0; i < items.size(); i++) {
            ret += "/" + items[i]; 
        }
        
        //return string 
        return ret; 
    }
};
