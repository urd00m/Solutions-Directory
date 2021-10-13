bool areSimilar(vector<int> a, vector<int> b) {
    int outOfPlace = 0; 
    if(a.size() != b.size()) return false; 
    int a1 = -1; 
    int a2 = -1; 
    int b1 = -1;
    int b2 = -1; 
    for(long i = 0; i < a.size(); i++) {
        if(a[i] != b[i]) {
            outOfPlace++; 
            if(outOfPlace == 1) {
                a1 = a[i];
                b1 = b[i]; 
            }
            else {
                a2 = a[i];
                b2 = b[i]; 
            }
        }
    }
    if(outOfPlace > 2 || a1 != b2 || b1 != a2) return false;
    return true; 
}

