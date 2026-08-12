class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        int cpu_cycle =0;

        for(char c : tasks){
            freq[c-'A']++;
        }

        for(int num : freq){
            if(num>0){
                pq.offer(num);
            }
        }

        while(!pq.isEmpty() || !queue.isEmpty()){
            cpu_cycle += 1;

            if(!pq.isEmpty()){
                int curr_freq = pq.poll();
                if(curr_freq-1>0)
                    queue.add(new int[]{curr_freq-1, cpu_cycle+n});
            } 

            if(!queue.isEmpty()){
                if(cpu_cycle == queue.peek()[1]){
                    int[] curr = queue.poll();
                    pq.offer(curr[0]);
                }
            }
        
        }
        

        return cpu_cycle;


    }
}
