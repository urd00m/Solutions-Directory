bool isAdmissibleOverpayment(vector<double> prices, vector<string> notes, double x) {
    double EPS = 1e-9; 
    long double curSensitivity = 0; 
    for(long i = 0; i < prices.size(); i++) {
        // If it is less than in stores than we subtract
        // If it higher than instores than we add 
        if(notes[i] == "Same as in-store") continue; //do nothing 
        
        //Determine notes 
        string toConvert = ""; 
        size_t j = 0;
        for(j = 0; j < notes[i].length(); j++) {
            if(notes[i][j] == '%') {
                j+=2; //jump to the text 
                break;
            }
            toConvert += string(1, notes[i][j]); 
        }
        
        double higher = notes[i][j] == 'h' ? true : false; 
        long double percentage = stod(toConvert); 
        // if higher
        if(higher == true) {
            long double inStores = static_cast<long double>(prices[i])/((100.0+percentage)/100.0+EPS); 
            curSensitivity += prices[i] - inStores; 
        }
        if(higher == false) {
            long double inStores = static_cast<long double>(prices[i])/((100.0-percentage)/100.0 + EPS); 
            curSensitivity += prices[i] - inStores; 
        }
    }
    
    if(curSensitivity <= x+.00001) return true; 
    else return false; 
}

