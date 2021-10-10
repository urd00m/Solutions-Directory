vector<string> allLongestStrings(vector<string> inputArray) {
    vector<string> ret; 
    unsigned long max = 0; 
    for(unsigned long i = 0; i < inputArray.size(); i++)
 {
     if(inputArray[i].size() > max) {
        max = inputArray[i].size();
        ret.clear(); 
        ret.push_back(inputArray[i]); 
     }
     else if(inputArray[i].size() == max) {
         ret.push_back(inputArray[i]); 
     }
 }
 return ret; 
 
}

