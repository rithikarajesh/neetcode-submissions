class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        helper(nums,set);
        return res;
    }

    public void helper(int[] nums, HashSet<Integer> set){
        if(temp.size()==nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = 0; i <nums.length; i++){
            if(!set.contains(nums[i])){
                temp.add(nums[i]);
                set.add(nums[i]);
                helper(nums,set);
                temp.remove(temp.size()-1);
                set.remove(nums[i]);
            }

        }
    }
}
