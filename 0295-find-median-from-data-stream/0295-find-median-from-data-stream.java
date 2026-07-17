class MedianFinder {

    Queue<Integer> leftPartionMaxHeap;
    Queue<Integer> rigthPartionMaxHeap;


    public MedianFinder() {
        leftPartionMaxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
        rigthPartionMaxHeap = new PriorityQueue<>((n1,n2)->n1-n2);
    }
    
    public void addNum(int num) {
        leftPartionMaxHeap.add(num);
        rigthPartionMaxHeap.add(leftPartionMaxHeap.poll());

        if(leftPartionMaxHeap.size() < rigthPartionMaxHeap.size()){
            leftPartionMaxHeap.add(rigthPartionMaxHeap.poll());
        }   
    }
    public double findMedian() {

        if(leftPartionMaxHeap.size() > rigthPartionMaxHeap.size()){
            return leftPartionMaxHeap.peek();
        }
        return (leftPartionMaxHeap.peek() + rigthPartionMaxHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */