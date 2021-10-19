
bool isIPv4Address(string inputString) {
    //delimit by . 
    string num = ""; 
    int count = 0; 
    for(size_t i = 0; i < inputString.size(); i++) {
        if(inputString[i] == '.') {
            if(num == "" || num.size() > 3 || (num.size() > 1 && num[0] == '0')) return false; 
            int check = stoi(num); 
            if( !(check >= 0 && check <= 255) ) return false; 
            num = ""; 
            count++; 
        }
        else if(!(inputString[i] -'0' < 10 && inputString[i] -'0' >= 0)) {
            return false; 
        }
        else {
            num += string(1, inputString[i]);    
        }
    }
    if(num == "" || num.size() > 3 || (num.size() > 1 && num[0] == '0')) return false; 
    int check = stoi(num); 
    if( !(check >= 0 && check <= 255) ) return false;
    if(count != 3) return false; 
    return true; 
}

