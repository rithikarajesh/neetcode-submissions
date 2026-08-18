class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0);
        return res;

    }

    private void helper(int[] nums, int i){
        if(i == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(i>nums.length){
            return;
        }

        curr.add(nums[i]);
        helper(nums, i+1);

        curr.remove(curr.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i += 1;
        }
        helper(nums,i+1);
    }
}
