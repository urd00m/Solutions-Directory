class MedianFinder {
public:
    priority_queue<int> left, right; 
    MedianFinder() {
        left = priority_queue<int>(); // max heap 
        right = priority_queue<int>(); // min heap 
    }
    
    void addNum(int num) {
        left.push(num); 
        right.push(-left.top());
        left.pop(); 

        if(left.size() < right.size()) {
            left.push(-right.top()); 
            right.pop(); 
        }
    }
    
    double findMedian() {
        if(left.size() == right.size()) return (left.top() - right.top() ) / 2.0;
        else return left.top(); 
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
