class MyCalendarThree {
private:
    map<int, int> prefix;

public:
    MyCalendarThree() {
        prefix.clear(); 
    }

    int book(int start, int end) {
        int cur = 0, ret = 0;
        prefix[start]++; prefix[end]--;
        for (auto& [k, s] : prefix) {
            cur += s;
            ret = max(ret, cur);
        }
        return ret;
    }
};
