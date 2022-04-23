class Solution {
public:
    unordered_map<string, int> encodeMap; 
    unordered_map<int, string> decodeMap; 
    int count; 
    
    // Encodes a URL to a shortened URL.
    string encode(string longUrl) {
        if(encodeMap.find(longUrl) == encodeMap.end()) {
            encodeMap[longUrl] = count;
            decodeMap[count++] = longUrl; 
        }   
        return to_string(encodeMap[longUrl]);
    }

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl) {
        return decodeMap[stoi(shortUrl)];
    }
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));
