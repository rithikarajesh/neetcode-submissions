class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),i);
        }

        int seq_length = 0,end=0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length();i++){
            seq_length +=1;
            end = Math.max(end,map.get(s.charAt(i)));

            if(i==end){
                res.add(seq_length);
                seq_length = 0;
            }
        }

        return res;
        
    }
}
