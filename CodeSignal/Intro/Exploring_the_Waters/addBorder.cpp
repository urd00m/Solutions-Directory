vector<string> addBorder(vector<string> picture) {
    vector<string> ret; 
    ret.push_back(string(picture[0].size()+2, '*')); 
    for(size_t i = 0; i < picture.size(); i++) {
        string push = "*" + picture[i] + "*";
        ret.push_back(push);
    }
    ret.push_back(string(picture[0].size()+2, '*')); 
    return ret; 
}

