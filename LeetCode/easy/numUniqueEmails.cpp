class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        unordered_set<string> exists; 
        for(string mail : emails) {
            bool atsign = false;
            bool ignore = false; 
            string true_mail = ""; 
            for(unsigned long i = 0; i < mail.length(); i++) {
                if(atsign == false && mail[i] == '+') {
                    ignore = true;
                    continue; 
                }
                if(ignore == true && mail[i] != '@') continue; 
                if(mail[i] == '@') {
                    atsign = true; 
                    ignore = false;
                }
                if(atsign == false && mail[i] == '.') continue; 
                true_mail += string(1, mail[i]);
            }
            exists.insert(true_mail);
        }
        return static_cast<int>(exists.size());
    }
};
