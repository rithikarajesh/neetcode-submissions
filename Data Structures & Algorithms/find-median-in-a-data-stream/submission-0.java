class MedianFinder {
    PriorityQueue<Integer> max_heap;
    PriorityQueue<Integer> min_heap;

    public MedianFinder() {
         max_heap = new PriorityQueue<>(Collections.reverseOrder());
    min_heap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max_heap.isEmpty() || num<=max_heap.peek()){
            max_heap.offer(num);
        }
        else{
            min_heap.offer(num);
        }

        if(max_heap.size()>min_heap.size()+1){
            min_heap.offer(max_heap.poll());
        }
        else if(min_heap.size() > max_heap.size()+1){
            max_heap.offer(min_heap.poll());
        }
    }


    
    public double findMedian() {
        if(max_heap.size()==min_heap.size()){
            return (double)(min_heap.peek()+max_heap.peek())/2;
        }
        else if(max_heap.size()>min_heap.size()){
            return max_heap.peek();
        }
        else{
         return   min_heap.peek();
        }
    }
}
