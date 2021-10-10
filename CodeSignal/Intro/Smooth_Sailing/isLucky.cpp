#include <string>

bool isLucky(int n) {
    string item = to_string(n); 
    int countl = 0, countr = 0; 
    for(int i = 0; i < item.length()/2; i++) {
        countl += item[i] - '0';
    }
    for(int i = item.length()/2; i < item.length(); i++) {
        countr += item[i] - '0';
    }
    return countr == countl; 
}

