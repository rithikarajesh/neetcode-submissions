class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int max_len = 0;

        for(int num : nums){
            if(set.contains(num-1)){
                continue;
            }
            int len = 0;
            while(set.contains(num)){
                num+=1;
                len++;           
            }
            max_len = Math.max(len, max_len);

        }

        return max_len;
    }
}
