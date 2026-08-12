class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : stones){
            pq.add(num);
        }

        while(pq.size()>=2){
            int x = pq.remove();
            int y = pq.remove();

            if(x==y){
                continue;
            }

            pq.add(x-y);

        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.peek();
    }
}
